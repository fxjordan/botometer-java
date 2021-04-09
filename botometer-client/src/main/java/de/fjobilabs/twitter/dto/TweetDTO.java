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

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import de.fjobilabs.twitter.Coordinates;
import de.fjobilabs.twitter.Entities;
import de.fjobilabs.twitter.ExtendedEntities;
import de.fjobilabs.twitter.Place;
import de.fjobilabs.twitter.Rule;
import de.fjobilabs.twitter.Tweet;
import de.fjobilabs.twitter.User;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
@JsonIgnoreProperties(value = {"geo", "contributors", "metadata"}, ignoreUnknown = true)
@JsonInclude(Include.NON_DEFAULT)
public class TweetDTO implements Tweet {
    
    /*
     * TODO Support 'extended_tweet' attribute for longer Tweets.
     */
    
    private OffsetDateTime createdAt;
    private long id;
    private String idStr;
    private String text;
    private String source;
    private boolean truncated;
    private long inReplyToStatusId;
    private String inReplyToStatusIdStr;
    private long inReplyToUserId;
    private String inReplyToUserIdStr;
    private String inReplyToScreenName;
    private UserDTO user;
    private CoordinatesDTO coordinates;
    private PlaceDTO place;
    private long quotedStatusId;
    private String quotedStatusIdStr;
    @JsonProperty("is_quote_status")
    private boolean isQuoteStatus;
    private Tweet quotedStatus;
    private Tweet retweetedStatus;
    private int quoteCount;
    private int replyCount;
    private int retweetCount;
    private int favoriteCount;
    private EntitiesDTO entities;
    private ExtendedEntitiesDTO extendedEntities;
    private boolean favorited;
    private boolean retweeted;
    private boolean possiblySensitive;
    private String filterLevel;
    private Locale lang;
    private List<RuleDTO> matchingRules;
    private CurrentUserRetweet currentUserRetweet;
    // TODO Create type for scopes
    private Map<String, Object> scopes;
    private boolean withheldCopyright;
    private List<String> withheldCountries;
    private String withheldScope;
    
    /* For serialisation. */
    TweetDTO() {
    }
    
    public TweetDTO(Tweet tweet) {
        this.createdAt = tweet.getCreatedAt();
        this.id = tweet.getId();
        if (tweet.getId() != 0) {
            this.idStr = Long.toString(tweet.getId());
        }
        this.text = tweet.getText();
        this.source = tweet.getSource();
        this.truncated = tweet.isTruncated();
        this.inReplyToStatusId = tweet.getInReplyToStatusId();
        if (tweet.getInReplyToStatusId() != 0) {
            this.inReplyToStatusIdStr = Long.toString(tweet.getInReplyToStatusId());
        }
        this.inReplyToUserId = tweet.getInReplyToUserId();
        if (tweet.getInReplyToUserId() != 0) {
            this.inReplyToUserIdStr = Long.toString(tweet.getInReplyToUserId());
        }
        this.inReplyToScreenName = tweet.getInReplyToScreenName();
        if (tweet.getUser() != null) {
            this.user = new UserDTO(tweet.getUser());
        }
        if (tweet.getCoordinates() != null) {
            this.coordinates = new CoordinatesDTO(tweet.getCoordinates());
        }
        if (tweet.getPlace() != null) {
            this.place = new PlaceDTO(tweet.getPlace());
        }
        this.quotedStatusId = tweet.getQuotedStatusId();
        if (tweet.getQuotedStatusId() != 0) {
            this.quotedStatusIdStr = Long.toString(tweet.getQuotedStatusId());
        }
        this.isQuoteStatus = tweet.isQuoteStatus();
        if (tweet.getQuotedStatus() != null) {
            this.quotedStatus = new TweetDTO(tweet.getQuotedStatus());
        }
        if (tweet.getRetweetedStatus() != null) {
            this.retweetedStatus = new TweetDTO(tweet.getRetweetedStatus());
        }
        this.quoteCount = tweet.getQuoteCount();
        this.replyCount = tweet.getReplyCount();
        this.retweetCount = tweet.getRetweetCount();
        this.favoriteCount = tweet.getFavoriteCount();
        if (tweet.getEntities() != null) {
            this.entities = new EntitiesDTO(tweet.getEntities());
        }
        if (tweet.getExtendedEntities() != null) {
            this.extendedEntities = new ExtendedEntitiesDTO(tweet.getExtendedEntities());
        }
        this.favorited = tweet.isFavorited();
        this.retweeted = tweet.isRetweeted();
        this.possiblySensitive = tweet.isPossiblySensitive();
        this.filterLevel = tweet.getFilterLevel();
        this.lang = tweet.getLang();
        if (tweet.getMatchingRules() != null) {
            this.matchingRules = tweet.getMatchingRules().stream().map(RuleDTO::new).collect(Collectors.toList());
        }
        if (tweet.getCurrentUserRetweet() != null) {
            this.currentUserRetweet = new CurrentUserRetweetDTO(tweet.getCurrentUserRetweet());
        }
        if (tweet.getScopes() != null) {
            this.scopes = new HashMap<>(tweet.getScopes());
        }
        this.withheldCopyright = tweet.isWithheldCopyright();
        if (tweet.getWithheldCountries() != null) {
            this.withheldCountries = new ArrayList<>(tweet.getWithheldCountries());
        }
        this.withheldScope = tweet.getWithheldScope();
    }
    
    @JsonFormat(pattern = "EEE MMM dd HH:mm:ss Z yyyy", locale = "en")
    @Override
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
    
    @Override
    public long getId() {
        return id;
    }
    
    /* Not a property of 'Tweet' */
    public String getIdStr() {
        return idStr;
    }
    
    @Override
    public String getText() {
        return text;
    }
    
    @Override
    public String getSource() {
        return source;
    }
    
    @Override
    public boolean isTruncated() {
        return truncated;
    }
    
    @Override
    public long getInReplyToStatusId() {
        return inReplyToStatusId;
    }
    
    /* Not a property of 'Tweet' */
    public String getInReplyToStatusIdStr() {
        return inReplyToStatusIdStr;
    }
    
    @Override
    public long getInReplyToUserId() {
        return inReplyToUserId;
    }
    
    /* Not a property of 'Tweet' */
    public String getInReplyToUserIdStr() {
        return inReplyToUserIdStr;
    }
    
    @Override
    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }
    
    @Override
    public User getUser() {
        return user;
    }
    
    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }
    
    @Override
    public Place getPlace() {
        return place;
    }
    
    @Override
    public long getQuotedStatusId() {
        return quotedStatusId;
    }
    
    /* Not a property of 'Tweet' */
    public String getQuotedStatusIdStr() {
        return quotedStatusIdStr;
    }
    
    @Override
    public boolean isQuoteStatus() {
        return isQuoteStatus;
    }
    
    @JsonProperty(access = Access.WRITE_ONLY)
    @Override
    public Tweet getQuotedStatus() {
        return quotedStatus;
    }
    
    @JsonProperty(access = Access.WRITE_ONLY)
    @Override
    public Tweet getRetweetedStatus() {
        return retweetedStatus;
    }
    
    @Override
    public int getQuoteCount() {
        return quoteCount;
    }
    
    @Override
    public int getReplyCount() {
        return replyCount;
    }
    
    @Override
    public int getRetweetCount() {
        return retweetCount;
    }
    
    @Override
    public int getFavoriteCount() {
        return favoriteCount;
    }
    
    @Override
    public Entities getEntities() {
        return entities;
    }
    
    @Override
    public ExtendedEntities getExtendedEntities() {
        return extendedEntities;
    }
    
    @Override
    public boolean isFavorited() {
        return favorited;
    }
    
    @Override
    public boolean isRetweeted() {
        return retweeted;
    }
    
    @Override
    public boolean isPossiblySensitive() {
        return possiblySensitive;
    }
    
    @Override
    public String getFilterLevel() {
        return filterLevel;
    }
    
    @Override
    public Locale getLang() {
        return lang;
    }
    
    @Override
    public List<? extends Rule> getMatchingRules() {
        return matchingRules;
    }
    
    @Override
    public CurrentUserRetweet getCurrentUserRetweet() {
        return currentUserRetweet;
    }
    
    @Override
    public Map<String, Object> getScopes() {
        return scopes;
    }
    
    @Override
    public boolean isWithheldCopyright() {
        return withheldCopyright;
    }
    
    @Override
    public List<String> getWithheldCountries() {
        return withheldCountries;
    }
    
    @Override
    public String getWithheldScope() {
        return withheldScope;
    }
    
    /**
     * @since 0.1.0
     * @author Felix Jordan
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CurrentUserRetweetDTO implements CurrentUserRetweet {
        
        private long id;
        private String idStr;
        
        public CurrentUserRetweetDTO(CurrentUserRetweet currentUserRetweet) {
            this.id = currentUserRetweet.getId();
            this.idStr = Long.toString(currentUserRetweet.getId());
        }
        
        @Override
        public long getId() {
            return id;
        }
        
        /* Not a property of 'CurrentUserRetweet' */
        public String getIdStr() {
            return idStr;
        }
    }
}
