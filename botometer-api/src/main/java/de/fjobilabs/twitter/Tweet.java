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
