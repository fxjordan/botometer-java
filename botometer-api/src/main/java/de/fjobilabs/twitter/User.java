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
