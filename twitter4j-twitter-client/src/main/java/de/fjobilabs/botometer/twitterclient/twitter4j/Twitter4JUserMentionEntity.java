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
package de.fjobilabs.botometer.twitterclient.twitter4j;

import de.fjobilabs.twitter.UserMentionEntity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
class Twitter4JUserMentionEntity extends AbstractTwitter4JEntity implements UserMentionEntity {
    
    private twitter4j.UserMentionEntity userMentionEntity;
    
    Twitter4JUserMentionEntity(twitter4j.UserMentionEntity userMentionEntity) {
        super(userMentionEntity);
        this.userMentionEntity = userMentionEntity;
    }
    
    @Override
    public long getId() {
        return this.userMentionEntity.getId();
    }
    
    @Override
    public String getName() {
        return this.userMentionEntity.getName();
    }
    
    @Override
    public String getScreenName() {
        return this.userMentionEntity.getScreenName();
    }
}
