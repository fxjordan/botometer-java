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

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

import de.fjobilabs.twitter.BoundingBox;
import de.fjobilabs.twitter.Place;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
class Twitter4JPlace implements Place {
    
    private static final Logger logger = LoggerFactory.getLogger(Twitter4JPlace.class);
    
    private twitter4j.Place place;
    
    Twitter4JPlace(twitter4j.Place place) {
        if (place == null) {
            throw new IllegalArgumentException("place must not be null");
        }
        this.place = place;
    }
    
    @Override
    public String getId() {
        return this.place.getId();
    }
    
    @Override
    public String getUrl() {
        return this.place.getId();
    }
    
    @Override
    public String getPlaceType() {
        return this.place.getPlaceType();
    }
    
    @Override
    public String getName() {
        return this.place.getName();
    }
    
    @Override
    public String getFullName() {
        return this.place.getFullName();
    }
    
    @Override
    public String getCountryCode() {
        return this.place.getCountryCode();
    }
    
    @Override
    public String getCountry() {
        return this.place.getCountry();
    }
    
    @Override
    public BoundingBox getBoundingBox() {
        if (this.place.getBoundingBoxCoordinates() == null || this.place.getBoundingBoxType() == null) {
            return null;
        }
        return new Twitter4JBoundingBox(this.place.getBoundingBoxCoordinates(), this.place.getBoundingBoxType());
    }
    
    @Override
    public Object getAttributes() {
        logger.warn("Place.getAttributes() called, but not impemented by Twitter4JPlace");
        return null;
    }
}
