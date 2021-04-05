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
package de.fjobilabs.twitter.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import de.fjobilabs.twitter.Entities;
import de.fjobilabs.twitter.HashtagEntity;
import de.fjobilabs.twitter.MediaEntity;
import de.fjobilabs.twitter.PollEntity;
import de.fjobilabs.twitter.SymbolEntity;
import de.fjobilabs.twitter.URLEntity;
import de.fjobilabs.twitter.UserMentionEntity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntitiesDTO implements Entities {
    
    private List<HashtagEntityDTO> hashtags;
    private List<MediaEntityDTO> media;
    private List<URLEntityDTO> urls;
    private List<UserMentionEntityDTO> userMentions;
    private List<SymbolEntityDTO> symbols;
    private List<PollEntityDTO> polls;
    
    /* For serialisation. */
    EntitiesDTO() {
    }
    
    public EntitiesDTO(Entities entities) {
        if (entities.getHashtags() != null) {
            this.hashtags = entities.getHashtags().stream().map(HashtagEntityDTO::new).collect(Collectors.toList());
        }
        if (entities.getMedia() != null) {
            this.media = entities.getMedia().stream().map(MediaEntityDTO::new).collect(Collectors.toList());
        }
        if (entities.getUrls() != null) {
            this.urls = entities.getUrls().stream().map(URLEntityDTO::new).collect(Collectors.toList());
        }
        if (entities.getUserMentions() != null) {
            this.userMentions = entities.getUserMentions().stream().map(UserMentionEntityDTO::new)
                .collect(Collectors.toList());
        }
        if (entities.getSymbols() != null) {
            this.symbols = entities.getSymbols().stream().map(SymbolEntityDTO::new).collect(Collectors.toList());
        }
        if (entities.getPolls() != null) {
            this.polls = entities.getPolls().stream().map(PollEntityDTO::new).collect(Collectors.toList());
        }
    }
    
    @Override
    public List<? extends HashtagEntity> getHashtags() {
        return hashtags;
    }
    
    @Override
    public List<? extends MediaEntity> getMedia() {
        return media;
    }
    
    @Override
    public List<? extends URLEntity> getUrls() {
        return urls;
    }
    
    @Override
    public List<? extends UserMentionEntity> getUserMentions() {
        return userMentions;
    }
    
    @Override
    public List<? extends SymbolEntity> getSymbols() {
        return symbols;
    }
    
    @Override
    public List<? extends PollEntity> getPolls() {
        return polls;
    }
}
