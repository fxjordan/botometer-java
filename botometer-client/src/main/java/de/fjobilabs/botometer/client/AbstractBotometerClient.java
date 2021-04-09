/*
 * Copyright 2019 FJOBI Labs Softwareentwicklung - Felix Jordan
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     https://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.fjobilabs.botometer.client;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import de.fjobilabs.botometer.AccountData;
import de.fjobilabs.botometer.BotometerException;
import de.fjobilabs.botometer.ClassificationResult;
import de.fjobilabs.botometer.api.BotometerClient;
import de.fjobilabs.botometer.api.BotometerOperations;
import de.fjobilabs.botometer.api.BotometerRawOperations;
import de.fjobilabs.botometer.dto.AccountDataDTO;
import de.fjobilabs.twitter.Tweet;
import de.fjobilabs.twitter.User;
import de.fjobilabs.twitter.dto.TweetDTO;
import de.fjobilabs.twitter.dto.UserDTO;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public abstract class AbstractBotometerClient implements BotometerClient, BotometerRawOperations, BotometerOperations {
    
    protected ObjectMapper objectMapper;
    
    public AbstractBotometerClient() {
        this.objectMapper = ObjectMapperFactory.getInstance().create();
    }
    
    @Override
    public BotometerOperations getBotometerOperations() {
        return this;
    }
    
    @Override
    public BotometerRawOperations getRawOperations() {
        return this;
    }
    
    @Override
    public ClassificationResult checkAccount(AccountData accountData) throws BotometerException, IOException {
        return checkAccountDTO(new AccountDataDTO(accountData));
    }
    
    @Override
    public ClassificationResult checkAccount(User user, List<Tweet> timeline, List<Tweet> mentions)
        throws BotometerException, IOException {
        List<TweetDTO> timelineDtos = timeline.stream().map(TweetDTO::new).collect(Collectors.toList());
        List<TweetDTO> mentionsDtos = mentions.stream().map(TweetDTO::new).collect(Collectors.toList());
        return checkAccountDTO(new AccountDataDTO(new UserDTO(user), timelineDtos, mentionsDtos));
    }
    
    private ClassificationResult checkAccountDTO(AccountDataDTO accountData) throws BotometerException, IOException {
        try {
            return this.checkAccount(this.objectMapper.writeValueAsBytes(accountData));
        } catch (JsonProcessingException e) {
            throw new BotometerException("Failed to serialize account data to JSON", e);
        }
    }
    
    @Override
    public ClassificationResult checkAccount(String accountDataJson) throws BotometerException, IOException {
        return this.checkAccount(accountDataJson.getBytes());
    }
    
    @Override
    public ClassificationResult checkAccount(String userJson, String timelineJson, String mentionsJson)
        throws BotometerException, IOException {
        return this.checkAccount(userJson.getBytes(), timelineJson.getBytes(), mentionsJson.getBytes());
    }
    
    @Override
    public ClassificationResult checkAccount(byte[] userJson, byte[] timelineJson, byte[] mentionsJson)
        throws BotometerException, IOException {
        return this.checkAccount(createAccountDataJson(userJson, timelineJson, mentionsJson));
    }
    
    private byte[] createAccountDataJson(byte[] userJson, byte[] timelineJson, byte[] mentionsJson) {
        JsonNode userNode;
        ArrayNode timelineNode;
        ArrayNode mentionsNode;
        try {
            userNode = this.objectMapper.readTree(userJson);
        } catch (JsonParseException e) {
            throw new BotometerException("Invalid userJson", e);
        } catch (IOException e) {
            throw new BotometerException("Unexpected IOException while reading userJson", e);
        }
        try {
            timelineNode = this.objectMapper.readValue(timelineJson, ArrayNode.class);
        } catch (JsonParseException e) {
            throw new BotometerException("Invalid timelineJson", e);
        } catch (JsonMappingException e) {
            throw new BotometerException("Invalid timelineJson. Cannot map to array", e);
        } catch (IOException e) {
            throw new BotometerException("Unexpected IOException while reading timelineJson", e);
        }
        try {
            mentionsNode = this.objectMapper.readValue(mentionsJson, ArrayNode.class);
        } catch (JsonParseException e) {
            throw new BotometerException("Invalid mentionsJson", e);
        } catch (JsonMappingException e) {
            throw new BotometerException("Invalid mentionsJson. Cannot map to array", e);
        } catch (IOException e) {
            throw new BotometerException("Unexpected IOException while reading mentionsJson", e);
        }
        
        ObjectNode accountDataNode = this.objectMapper.createObjectNode();
        accountDataNode.set("user", userNode);
        accountDataNode.set("timeline", timelineNode);
        accountDataNode.set("mentions", mentionsNode);
        
        try {
            return this.objectMapper.writeValueAsBytes(accountDataNode);
        } catch (JsonProcessingException e) {
            throw new BotometerException("Unexpected Exception while composing accoutn datat JSON", e);
        }
    }
    
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
