package de.fjobilabs.twitter;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Locale;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface User {
    
    long getId();
    
    /* Ignore 'id_str' */
    
    String getName();
    
    String getScreenName();
    
    String getLocation();
    
    String getUrl();
    
    String getDescription();
    
    /* TODO Add types for 'derived' objects. */
    List<Object> getDerived();
    
    boolean isProtected();
    
    boolean isVerified();
    
    int getFollowersCount();
    
    int getFriendsCount();
    
    int getListedCount();
    
    int getFavouritesCount();
    
    int getStatusesCount();
    
    OffsetDateTime getCreatedAt();
    
    int getUtcOffset();
    
    String getTimeZone();
    
    boolean isGeoEnabled();
    
    Locale getLang();
    
    boolean isContributorsEnabled();
    
    String getProfileBackgroundColor();
    
    String getProfileBackgroundImageUrl();
    
    String getProfileBackgroundImageUrlHttps();
    
    boolean isProfileBackgroundTile();
    
    String getProfileBannerUrl();
    
    String getProfileImageUrl();
    
    String getProfileImageUrlHttps();
    
    String getProfileLinkColor();
    
    String getProfileSidebarBorderColor();
    
    String getProfileSidebarFillColor();
    
    String getProfileTextColor();
    
    boolean isProfileUseBackgroundImage();
    
    boolean isDefaultProfile();
    
    boolean isDefaultProfileImage();
    
    List<String> getWithheldInCountries();
    
    String getWithheldScope();
    
}
