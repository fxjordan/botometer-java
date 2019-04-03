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
package de.fjobilabs.botometer.twitterclient.twitter4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.fjobilabs.twitter.Entities;
import de.fjobilabs.twitter.HashtagEntity;
import de.fjobilabs.twitter.MediaEntity;
import de.fjobilabs.twitter.PollEntity;
import de.fjobilabs.twitter.SymbolEntity;
import de.fjobilabs.twitter.URLEntity;
import de.fjobilabs.twitter.UserMentionEntity;

import twitter4j.EntitySupport;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
class Twitter4JEntities implements Entities {
    
    private static final Logger logger = LoggerFactory.getLogger(Twitter4JEntities.class);
    
    private EntitySupport entitySupport;
    
    Twitter4JEntities(EntitySupport entitySupport) {
        this.entitySupport = entitySupport;
    }
    
    @Override
    public List<? extends HashtagEntity> getHashtags() {
        if (this.entitySupport.getHashtagEntities() != null) {
            return Arrays.stream(this.entitySupport.getHashtagEntities()).map(Twitter4JHashtagEntity::new)
                .collect(Collectors.toList());
        }
        return null;
    }
    
    @Override
    public List<? extends MediaEntity> getMedia() {
        if (this.entitySupport.getMediaEntities() != null) {
            return Arrays.stream(this.entitySupport.getMediaEntities()).map(Twitter4JMediaEntity::new)
                .collect(Collectors.toList());
        }
        return null;
    }
    
    @Override
    public List<? extends URLEntity> getUrls() {
        if (this.entitySupport.getURLEntities() != null) {
            return Arrays.stream(this.entitySupport.getURLEntities()).map(Twitter4JURLEntity::new)
                .collect(Collectors.toList());
        }
        return null;
    }
    
    @Override
    public List<? extends UserMentionEntity> getUserMentions() {
        if (this.entitySupport.getUserMentionEntities() != null) {
            return Arrays.stream(this.entitySupport.getUserMentionEntities()).map(Twitter4JUserMentionEntity::new)
                .collect(Collectors.toList());
        }
        return null;
    }
    
    @Override
    public List<? extends SymbolEntity> getSymbols() {
        if (this.entitySupport.getSymbolEntities() != null) {
            return Arrays.stream(this.entitySupport.getSymbolEntities()).map(Twitter4JSymbolEntity::new)
                .collect(Collectors.toList());
        }
        return null;
    }
    
    @Override
    public List<? extends PollEntity> getPolls() {
        logger.warn("Entities.getPolls() called, but not impemented by Twitter4JEntities");
        return null;
    }
}
