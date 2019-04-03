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

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.fjobilabs.twitter.Coordinates;
import de.fjobilabs.twitter.Entities;
import de.fjobilabs.twitter.ExtendedEntities;
import de.fjobilabs.twitter.Place;
import de.fjobilabs.twitter.Rule;
import de.fjobilabs.twitter.Tweet;
import de.fjobilabs.twitter.User;

import twitter4j.Status;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
class Twitter4JTweet implements Tweet {
    
    private static final Logger logger = LoggerFactory.getLogger(Twitter4JTweet.class);
    
    private Status status;
    
    Twitter4JTweet(Status status) {
        this.status = status;
    }
    
    @Override
    public OffsetDateTime getCreatedAt() {
        if (this.status != null) {
            return this.status.getCreatedAt().toInstant().atOffset(ZoneOffset.UTC);
        }
        return null;
    }
    
    @Override
    public long getId() {
        return this.status.getId();
    }
    
    @Override
    public String getText() {
        return this.status.getText();
    }
    
    @Override
    public String getSource() {
        return this.status.getSource();
    }
    
    @Override
    public boolean isTruncated() {
        return this.status.isTruncated();
    }
    
    @Override
    public long getInReplyToStatusId() {
        return this.status.getInReplyToStatusId();
    }
    
    @Override
    public long getInReplyToUserId() {
        return this.status.getInReplyToUserId();
    }
    
    @Override
    public String getInReplyToScreenName() {
        return this.status.getInReplyToScreenName();
    }
    
    @Override
    public User getUser() {
        if (this.status.getUser() != null) {
            return new Twitter4JUser(this.status.getUser());
        }
        return null;
    }
    
    @Override
    public Coordinates getCoordinates() {
        if (this.status.getGeoLocation() != null) {
            return new Twitter4JCoordinates(this.status.getGeoLocation());
        }
        return null;
    }
    
    @Override
    public Place getPlace() {
        if (this.status.getPlace() != null) {
            return new Twitter4JPlace(this.status.getPlace());
        }
        return null;
    }
    
    @Override
    public long getQuotedStatusId() {
        return this.status.getQuotedStatusId();
    }
    
    @Override
    public boolean isQuoteStatus() {
        logger.warn("Tweet.isQuoteStatus() called, but not impemented by Twitter4JTweet");
        return false;
    }
    
    @Override
    public Tweet getQuotedStatus() {
        if (this.status.getQuotedStatus() != null) {
            return new Twitter4JTweet(this.status.getQuotedStatus());
        }
        return null;
    }
    
    @Override
    public Tweet getRetweetedStatus() {
        if (this.status.getRetweetedStatus() != null) {
            return new Twitter4JTweet(this.status.getRetweetedStatus());
        }
        return null;
    }
    
    @Override
    public int getQuoteCount() {
        logger.warn("Tweet.getQuoteCount() called, but not impemented by Twitter4JTweet");
        return 0;
    }
    
    @Override
    public int getReplyCount() {
        logger.warn("Tweet.getReplyCount() called, but not impemented by Twitter4JTweet");
        return 0;
    }
    
    @Override
    public int getRetweetCount() {
        return this.status.getRetweetCount();
    }
    
    @Override
    public int getFavoriteCount() {
        return this.status.getFavoriteCount();
    }
    
    @Override
    public Entities getEntities() {
        return new Twitter4JEntities(this.status);
    }
    
    @Override
    public ExtendedEntities getExtendedEntities() {
        logger.warn("Tweet.getExtendedEntities() called, but not impemented by Twitter4JTweet");
        return null;
    }
    
    @Override
    public boolean isFavorited() {
        return this.status.isFavorited();
    }
    
    @Override
    public boolean isRetweeted() {
        return this.status.isRetweeted();
    }
    
    @Override
    public boolean isPossiblySensitive() {
        return this.status.isPossiblySensitive();
    }
    
    @Override
    public String getFilterLevel() {
        logger.warn("Tweet.getFilterLevel() called, but not impemented by Twitter4JTweet");
        return null;
    }
    
    @Override
    public Locale getLang() {
        return new Locale(this.status.getLang());
    }
    
    @Override
    public List<? extends Rule> getMatchingRules() {
        logger.warn("Tweet.getMatchingRules() called, but not impemented by Twitter4JTweet");
        return null;
    }
    
    @Override
    public CurrentUserRetweet getCurrentUserRetweet() {
        return new CurrentUserRetweet() {
            
            @Override
            public long getId() {
                return Twitter4JTweet.this.status.getCurrentUserRetweetId();
            }
        };
    }
    
    @Override
    public Map<String, Object> getScopes() {
        logger.warn("Tweet.getScopes() called, but not impemented by Twitter4JTweet");
        return null;
    }
    
    @Override
    public boolean isWithheldCopyright() {
        logger.warn("Tweet.isWithheldCopyright() called, but not impemented by Twitter4JTweet");
        return false;
    }
    
    @Override
    public List<String> getWithheldCountries() {
        logger.warn("Tweet.getWithheldCountries() called, but not impemented by Twitter4JTweet");
        return null;
    }
    
    @Override
    public String getWithheldScope() {
        logger.warn("Tweet.getWithheldScope() called, but not impemented by Twitter4JTweet");
        return null;
    }
}
