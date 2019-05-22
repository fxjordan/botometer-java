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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.fjobilabs.twitter.User;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
class Twitter4JUser implements User {
    
    private static Logger logger = LoggerFactory.getLogger(Twitter4JUser.class);
    
    private twitter4j.User user;
    
    Twitter4JUser(twitter4j.User user) {
        if (user == null) {
            throw new IllegalArgumentException("user must not be null");
        }
        this.user = user;
    }
    
    @Override
    public long getId() {
        return this.user.getId();
    }
    
    @Override
    public String getName() {
        return this.user.getName();
    }
    
    @Override
    public String getScreenName() {
        return this.user.getScreenName();
    }
    
    @Override
    public String getLocation() {
        return this.user.getLocation();
    }
    
    @Override
    public String getUrl() {
        return this.user.getURL();
    }
    
    @Override
    public String getDescription() {
        return this.user.getDescription();
    }
    
    @Override
    public List<Object> getDerived() {
        logger.trace("User.getDerived() called, but not impemented by Twitter4JUser");
        return Collections.emptyList();
    }
    
    @Override
    public boolean isProtected() {
        return this.user.isProtected();
    }
    
    @Override
    public boolean isVerified() {
        return this.user.isVerified();
    }
    
    @Override
    public int getFollowersCount() {
        return this.user.getFollowersCount();
    }
    
    @Override
    public int getFriendsCount() {
        return this.user.getFollowersCount();
    }
    
    @Override
    public int getListedCount() {
        return this.user.getListedCount();
    }
    
    @Override
    public int getFavouritesCount() {
        return this.user.getFavouritesCount();
    }
    
    @Override
    public int getStatusesCount() {
        return this.user.getStatusesCount();
    }
    
    @Override
    public OffsetDateTime getCreatedAt() {
        if (this.user.getCreatedAt() == null) {
            return null;
        }
        return OffsetDateTime.from(this.user.getCreatedAt().toInstant().atOffset(ZoneOffset.UTC));
    }
    
    @Override
    public int getUtcOffset() {
        return this.user.getUtcOffset();
    }
    
    @Override
    public String getTimeZone() {
        return this.user.getTimeZone();
    }
    
    @Override
    public boolean isGeoEnabled() {
        return this.user.isGeoEnabled();
    }
    
    @Override
    public Locale getLang() {
        if (this.user.getLang() == null) {
            return null;
        }
        return new Locale(this.user.getLang());
    }
    
    @Override
    public boolean isContributorsEnabled() {
        return this.user.isContributorsEnabled();
    }
    
    @Override
    public String getProfileBackgroundColor() {
        return this.user.getProfileBackgroundColor();
    }
    
    @Override
    public String getProfileBackgroundImageUrl() {
        return this.user.getProfileBackgroundImageURL();
    }
    
    @Override
    public String getProfileBackgroundImageUrlHttps() {
        return this.user.getProfileBackgroundImageUrlHttps();
    }
    
    @Override
    public boolean isProfileBackgroundTile() {
        return this.user.isProfileBackgroundTiled();
    }
    
    @Override
    public String getProfileBannerUrl() {
        return this.user.getProfileBannerURL();
    }
    
    @Override
    public String getProfileImageUrl() {
        return this.user.getProfileImageURL();
    }
    
    @Override
    public String getProfileImageUrlHttps() {
        return this.user.getProfileImageURLHttps();
    }
    
    @Override
    public String getProfileLinkColor() {
        return this.user.getProfileLinkColor();
    }
    
    @Override
    public String getProfileSidebarBorderColor() {
        return this.user.getProfileSidebarBorderColor();
    }
    
    @Override
    public String getProfileSidebarFillColor() {
        return this.user.getProfileSidebarFillColor();
    }
    
    @Override
    public String getProfileTextColor() {
        return this.user.getProfileTextColor();
    }
    
    @Override
    public boolean isProfileUseBackgroundImage() {
        return this.user.isProfileUseBackgroundImage();
    }
    
    @Override
    public boolean isDefaultProfile() {
        return this.user.isDefaultProfile();
    }
    
    @Override
    public boolean isDefaultProfileImage() {
        return this.user.isDefaultProfileImage();
    }
    
    @Override
    public List<String> getWithheldInCountries() {
        if (this.user.getWithheldInCountries() == null) {
            return null;
        }
        return Arrays.asList(this.user.getWithheldInCountries());
    }
    
    @Override
    public String getWithheldScope() {
        logger.trace("User.getWithheldScope() called, but not impemented by Twitter4JUser");
        return null;
    }
}
