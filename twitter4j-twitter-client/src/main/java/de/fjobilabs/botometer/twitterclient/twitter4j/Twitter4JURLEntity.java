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

import de.fjobilabs.twitter.URLEntity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
class Twitter4JURLEntity extends AbstractTwitter4JEntity implements URLEntity {
    
    private twitter4j.URLEntity urlEntity;
    
    Twitter4JURLEntity(twitter4j.URLEntity urlEntity) {
        super(urlEntity);
        this.urlEntity = urlEntity;
    }
    
    @Override
    public String getDisplayURL() {
        return this.urlEntity.getDisplayURL();
    }
    
    @Override
    public String getExpandedURL() {
        return this.urlEntity.getExpandedURL();
    }
    
    @Override
    public String getURL() {
        return this.urlEntity.getURL();
    }
}
