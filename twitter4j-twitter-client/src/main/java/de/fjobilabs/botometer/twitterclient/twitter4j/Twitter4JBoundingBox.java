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

import de.fjobilabs.twitter.BoundingBox;

import twitter4j.GeoLocation;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
class Twitter4JBoundingBox implements BoundingBox {
    
    private float[][][] coordinates;
    private String type;
    
    Twitter4JBoundingBox(GeoLocation[][] coordinates, String type) {
        if (coordinates == null) {
            throw new IllegalArgumentException("coordinates must not be null");
        }
        if (type == null) {
            throw new IllegalArgumentException("type must not be null");
        }
        
        this.coordinates = new float[coordinates.length][][];
        for (int i = 0; i < coordinates.length; i++) {
            GeoLocation locations[] = coordinates[i];
            this.coordinates[i] = new float[locations.length][];
            for (int j = 0; j < locations.length; j++) {
                this.coordinates[i][j] = new float[] {(float) locations[j].getLongitude(),
                    (float) locations[j].getLatitude()};
            }
        }
        this.type = type;
    }
    
    @Override
    public float[][][] getCoordinates() {
        return coordinates;
    }
    
    @Override
    public String getType() {
        return type;
    }
}
