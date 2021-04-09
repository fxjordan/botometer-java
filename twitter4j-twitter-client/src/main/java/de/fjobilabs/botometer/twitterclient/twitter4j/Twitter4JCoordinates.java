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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.fjobilabs.twitter.Coordinates;

import twitter4j.GeoLocation;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
class Twitter4JCoordinates implements Coordinates {
    
    private static final Logger logger = LoggerFactory.getLogger(Twitter4JCoordinates.class);
    
    private GeoLocation geoLocation;
    
    Twitter4JCoordinates(GeoLocation geoLocation) {
        if (geoLocation == null) {
            throw new IllegalArgumentException("geoLocation must not be null");
        }
        this.geoLocation = geoLocation;
    }
    
    @Override
    public float getLongitude() {
        return (float) this.geoLocation.getLongitude();
    }
    
    @Override
    public float getLatitude() {
        return (float) this.geoLocation.getLatitude();
    }
    
    @Override
    public String getType() {
        logger.trace("Coordinates.getType() called, but not impemented by Twitter4JCoordinates");
        // We use the default from Twitter API documentation here
        return "Point";
    }
}
