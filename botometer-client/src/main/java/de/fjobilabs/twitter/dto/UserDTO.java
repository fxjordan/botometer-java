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
package de.fjobilabs.twitter.dto;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.fjobilabs.twitter.User;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
/*
 * Attributes 'following' and 'is_translator' are deprecated.
 * 
 * TODO Check if we really can ignore 'entities' for user
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"following", "is_translator", "follow_request_sent",
    "notifications", "has_extended_profile", "entities", "is_translation_enabled", "translator_type"})
public class UserDTO implements User {
    
    private long id;
    private String idStr;
    private String name;
    private String screenName;
    private String location;
    private String url;
    private String description;
    // TODO Add types for 'derived' objects
    private List<Object> derived;
    @JsonProperty("protected")
    private boolean _protected;
    private boolean verified;
    private int followersCount;
    private int friendsCount;
    private int listedCount;
    private int favouritesCount;
    private int statusesCount;
    private OffsetDateTime createdAt;
    private int utcOffset;
    private String timeZone;
    private boolean geoEnabled;
    private Locale lang;
    private boolean contributorsEnabled;
    private String profileBackgroundColor;
    private String profileBackgroundImageUrl;
    private String profileBackgroundImageUrlHttps;
    private boolean profileBackgroundTile;
    private String profileBannerUrl;
    private String profileImageUrl;
    private String profileImageUrlHttps;
    private String profileLinkColor;
    private String profileSidebarBorderColor;
    private String profileSidebarFillColor;
    private String profileTextColor;
    private boolean profileUseBackgroundImage;
    private boolean defaultProfile;
    private boolean defaultProfileImage;
    private List<String> withheldInCountries;
    private String withheldScope;
    
    /* For serialisation. */
    UserDTO() {
    }
    
    /**
     * Constructs a UserDTO from a {@link User}.
     * 
     * @param user
     */
    public UserDTO(User user) {
        this.id = user.getId();
        if (user.getId() != 0) {
            this.idStr = Long.toString(user.getId());
        }
        this.name = user.getName();
        this.screenName = user.getScreenName();
        this.location = user.getLocation();
        this.url = user.getUrl();
        this.description = user.getDescription();
        if (user.getDerived() != null) {
            this.derived = new ArrayList<>(user.getDerived());
        }
        this._protected = user.isProtected();
        this.verified = user.isVerified();
        this.followersCount = user.getFollowersCount();
        this.friendsCount = user.getFriendsCount();
        this.listedCount = user.getListedCount();
        this.favouritesCount = user.getFavouritesCount();
        this.statusesCount = user.getStatusesCount();
        this.createdAt = user.getCreatedAt();
        this.utcOffset = user.getUtcOffset();
        this.timeZone = user.getTimeZone();
        this.geoEnabled = user.isGeoEnabled();
        this.lang = user.getLang();
        this.contributorsEnabled = user.isContributorsEnabled();
        this.profileBackgroundColor = user.getProfileBackgroundColor();
        this.profileBackgroundImageUrl = user.getProfileBackgroundImageUrl();
        this.profileBackgroundImageUrlHttps = user.getProfileBackgroundImageUrlHttps();
        this.profileBackgroundTile = user.isProfileBackgroundTile();
        this.profileBannerUrl = user.getProfileBannerUrl();
        this.profileImageUrl = user.getProfileImageUrl();
        this.profileImageUrlHttps = user.getProfileImageUrlHttps();
        this.profileLinkColor = user.getProfileLinkColor();
        this.profileSidebarBorderColor = user.getProfileSidebarBorderColor();
        this.profileSidebarFillColor = user.getProfileSidebarFillColor();
        this.profileTextColor = user.getProfileTextColor();
        this.profileUseBackgroundImage = user.isProfileUseBackgroundImage();
        this.defaultProfile = user.isDefaultProfile();
        this.defaultProfileImage = user.isDefaultProfileImage();
        if (user.getWithheldInCountries() != null) {
            this.withheldInCountries = new ArrayList<>(user.getWithheldInCountries());
        }
        this.withheldScope = user.getWithheldScope();
    }
    
    @Override
    public long getId() {
        return id;
    }
    
    /* Not a property of 'User' */
    public String getIdStr() {
        return idStr;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getScreenName() {
        return screenName;
    }
    
    @Override
    public String getLocation() {
        return location;
    }
    
    @Override
    public String getUrl() {
        return url;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public List<Object> getDerived() {
        return derived;
    }
    
    @Override
    public boolean isProtected() {
        return _protected;
    }
    
    @Override
    public boolean isVerified() {
        return verified;
    }
    
    @Override
    public int getFollowersCount() {
        return followersCount;
    }
    
    @Override
    public int getFriendsCount() {
        return friendsCount;
    }
    
    @Override
    public int getListedCount() {
        return listedCount;
    }
    
    @Override
    public int getFavouritesCount() {
        return favouritesCount;
    }
    
    @Override
    public int getStatusesCount() {
        return statusesCount;
    }
    
    @JsonFormat(pattern = "EEE MMM dd HH:mm:ss Z yyyy", locale = "en")
    @Override
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
    
    @Override
    public int getUtcOffset() {
        return utcOffset;
    }
    
    @Override
    public String getTimeZone() {
        return timeZone;
    }
    
    @Override
    public boolean isGeoEnabled() {
        return geoEnabled;
    }
    
    @Override
    public Locale getLang() {
        return lang;
    }
    
    @Override
    public boolean isContributorsEnabled() {
        return contributorsEnabled;
    }
    
    @Override
    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }
    
    @Override
    public String getProfileBackgroundImageUrl() {
        return profileBackgroundImageUrl;
    }
    
    @Override
    public String getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }
    
    @Override
    public boolean isProfileBackgroundTile() {
        return profileBackgroundTile;
    }
    
    @Override
    public String getProfileBannerUrl() {
        return profileBannerUrl;
    }
    
    @Override
    public String getProfileImageUrl() {
        return profileImageUrl;
    }
    
    @Override
    public String getProfileImageUrlHttps() {
        return profileImageUrlHttps;
    }
    
    @Override
    public String getProfileLinkColor() {
        return profileLinkColor;
    }
    
    @Override
    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }
    
    @Override
    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }
    
    @Override
    public String getProfileTextColor() {
        return profileTextColor;
    }
    
    @Override
    public boolean isProfileUseBackgroundImage() {
        return profileUseBackgroundImage;
    }
    
    @Override
    public boolean isDefaultProfile() {
        return defaultProfile;
    }
    
    @Override
    public boolean isDefaultProfileImage() {
        return defaultProfileImage;
    }
    
    @Override
    public List<String> getWithheldInCountries() {
        return withheldInCountries;
    }
    
    @Override
    public String getWithheldScope() {
        return withheldScope;
    }
}
