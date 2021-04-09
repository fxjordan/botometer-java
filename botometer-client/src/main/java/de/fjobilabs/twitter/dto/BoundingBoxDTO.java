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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import de.fjobilabs.twitter.BoundingBox;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoundingBoxDTO implements BoundingBox {
    
    private float[][][] coordinates;
    private String type;
    
    public BoundingBoxDTO(BoundingBox boundingBox) {
        this.coordinates = boundingBox.getCoordinates();
        this.type = boundingBox.getType();
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
