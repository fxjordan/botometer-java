/*
 * Copyright 2019 FJOBI Labs Softwareentwicklung - Felix Jordan
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.fjobilabs.botometer;

import de.fjobilabs.botometer.api.BotometerClientFactory;
import de.fjobilabs.botometer.twitterclient.TwitterClientFactory;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class BotometerConfiguration {
    
    private BotometerClientFactory botometerClientFactory;
    private TwitterClientFactory twitterClientFactory;
    private String botometerApiKey;
    private String twitterConsumerKey;
    private String twitterConsumerSecret;
    private String twitterAccessToken;
    private String twitterAccessTokenSecret;
    
    BotometerConfiguration(BotometerClientFactory botometerClientFactory, TwitterClientFactory twitterClientFactory,
        String botometerApiKey, String twitterConsumerKey, String twitterConsumerSecret, String twitterAccessToken,
        String twitterAccessTokenSecret) {
        this.botometerClientFactory = botometerClientFactory;
        this.twitterClientFactory = twitterClientFactory;
        this.botometerApiKey = botometerApiKey;
        this.twitterConsumerKey = twitterConsumerKey;
        this.twitterConsumerSecret = twitterConsumerSecret;
        this.twitterAccessToken = twitterAccessToken;
        this.twitterAccessTokenSecret = twitterAccessTokenSecret;
    }
    
    BotometerConfiguration(BotometerConfiguration configuration) {
        this.botometerClientFactory = configuration.getBotometerClientFactory();
        this.twitterClientFactory = configuration.getTwitterClientFactory();
        this.botometerApiKey = configuration.getBotometerApiKey();
        this.twitterConsumerKey = configuration.getTwitterConsumerKey();
        this.twitterConsumerSecret = configuration.getTwitterConsumerSecret();
        this.twitterAccessToken = configuration.getTwitterAccessToken();
        this.twitterAccessTokenSecret = configuration.getTwitterAccessTokenSecret();
    }
    
    void validate() {
        if (!this.hasBotometerApiKey()) {
            throw new IllegalArgumentException("Invalid configuration: botometerApiKey must be set");
        }
        if ((this.hasTwitterConsumerKey() || this.hasTwitterConsumerSecret())
            && (!this.hasTwitterConsumerKey() || !this.hasTwitterConsumerSecret())) {
            throw new IllegalArgumentException(
                "Invalid configuration: twitterConsumerKey and twitterConsumerSecret must both be set");
        }
        if ((this.hasTwitterAccessToken() || this.hasTwitterAccessTokenSecret())
            && (!this.hasTwitterAccessToken() || !this.hasTwitterAccessTokenSecret())) {
            throw new IllegalArgumentException(
                "Invalid configuration: twitterAccessToken and twitterAccessTokenSecret must both be set");
        }
        
        /*
         * This ensures that IF accessToken+accessTokenSecret are specified
         * consumerKey+consumerSecret ALSO NEED to be set.
         */
        if (this.hasTwitterAccessToken() && !this.hasTwitterConsumerKey()) {
            throw new IllegalArgumentException(
                "Invalid configuration: If accessToken is specified, consumerKey/Secret also need to be set");
        }
    }
    
    public BotometerClientFactory getBotometerClientFactory() {
        return botometerClientFactory;
    }
    
    void setBotometerClientFactory(BotometerClientFactory botometerClientFactory) {
        this.botometerClientFactory = botometerClientFactory;
    }
    
    public boolean hasBotometerClientFactory() {
        return this.botometerClientFactory != null;
    }
    
    public TwitterClientFactory getTwitterClientFactory() {
        return twitterClientFactory;
    }
    
    void setTwitterClientFactory(TwitterClientFactory twitterClientFactory) {
        this.twitterClientFactory = twitterClientFactory;
    }
    
    public boolean hasTwitterClientFactory() {
        return this.twitterClientFactory != null;
    }
    
    public String getBotometerApiKey() {
        return botometerApiKey;
    }
    
    void setBotometerApiKey(String botometerApiKey) {
        this.botometerApiKey = botometerApiKey;
    }
    
    public boolean hasBotometerApiKey() {
        return this.botometerApiKey != null;
    }
    
    public String getTwitterConsumerKey() {
        return twitterConsumerKey;
    }
    
    void setTwitterConsumerKey(String twitterConsumerKey) {
        this.twitterConsumerKey = twitterConsumerKey;
    }
    
    public boolean hasTwitterConsumerKey() {
        return this.twitterConsumerKey != null;
    }
    
    public String getTwitterConsumerSecret() {
        return twitterConsumerSecret;
    }
    
    void setTwitterConsumerSecret(String twitterConsumerSecret) {
        this.twitterConsumerSecret = twitterConsumerSecret;
    }
    
    public boolean hasTwitterConsumerSecret() {
        return this.twitterConsumerSecret != null;
    }
    
    public String getTwitterAccessToken() {
        return twitterAccessToken;
    }
    
    void setTwitterAccessToken(String twitterAccessToken) {
        this.twitterAccessToken = twitterAccessToken;
    }
    
    public boolean hasTwitterAccessToken() {
        return this.twitterAccessToken != null;
    }
    
    public String getTwitterAccessTokenSecret() {
        return twitterAccessTokenSecret;
    }
    
    void setTwitterAccessTokenSecret(String twitterAccessTokenSecret) {
        this.twitterAccessTokenSecret = twitterAccessTokenSecret;
    }
    
    public boolean hasTwitterAccessTokenSecret() {
        return this.twitterAccessTokenSecret != null;
    }
}
