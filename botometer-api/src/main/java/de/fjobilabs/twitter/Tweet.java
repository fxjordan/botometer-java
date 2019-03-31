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
package de.fjobilabs.twitter;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface Tweet {
    
    OffsetDateTime getCreatedAt();
    
    long getId();
    
    String getText();
    
    String getSource();
    
    boolean isTruncated();
    
    long getInReplyToStatusId();
    
    long getInReplyToUserId();
    
    String getInReplyToScreenName();
    
    User getUser();
    
    Coordinates getCoordinates();
    
    Place getPlace();
    
    long getQuotedStatusId();
    
    boolean isQuoteStatus();
    
    Tweet getQuotedStatus();
    
    Tweet getRetweetedStatus();
    
    int getQuoteCount();
    
    int getReplyCount();
    
    int getRetweetCount();
    
    int getFavoriteCount();
    
    Entities getEntities();
    
    ExtendedEntities getExtendedEntities();
    
    boolean isFavorited();
    
    boolean isRetweeted();
    
    boolean isPossiblySensitive();
    
    String getFilterLevel();
    
    Locale getLang();
    
    List<? extends Rule> getMatchingRules();
    
    CurrentUserRetweet getCurrentUserRetweet();
    
    Map<String, Object> getScopes();
    
    boolean isWithheldCopyright();
    
    List<String> getWithheldCountries();
    
    String getWithheldScope();
    
    /**
     * @since 0.1.0
     * @author Felix Jordan
     */
    interface CurrentUserRetweet {
        
        long getId();
    }
}
