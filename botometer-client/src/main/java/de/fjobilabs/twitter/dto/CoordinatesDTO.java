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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import de.fjobilabs.twitter.Coordinates;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoordinatesDTO implements Coordinates {
    
    private float[] coordinates;
    private String type;
    
    public CoordinatesDTO(Coordinates coordinates) {
        this.coordinates = new float[] {coordinates.getLatitude(), coordinates.getLongitude()};
        this.type = coordinates.getType();
    }
    
    /* Not a property of 'Coordinates' */
    public float[] getCoordinates() {
        return coordinates;
    }
    
    /* No attribute of the actual resource. */
    @JsonIgnore
    @Override
    public float getLongitude() {
        if (this.coordinates.length != 2) {
            throw new IllegalStateException("coordinates array not valid! coordinates.length must be 2");
        }
        return this.coordinates[0];
    }
    
    /* No attribute of the actual resource. */
    @JsonIgnore
    @Override
    public float getLatitude() {
        if (this.coordinates.length != 2) {
            throw new IllegalStateException("coordinates array not valid! coordinates.length must be 2");
        }
        return this.coordinates[1];
    }
    
    @Override
    public String getType() {
        return type;
    }
}
