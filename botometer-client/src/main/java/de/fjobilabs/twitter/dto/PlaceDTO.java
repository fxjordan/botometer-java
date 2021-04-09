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
import de.fjobilabs.twitter.Place;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceDTO implements Place {
    
    private String id;
    private String url;
    private String placeType;
    private String name;
    private String fullName;
    private String countryCode;
    private String country;
    private BoundingBoxDTO boundingBox;
    /* TODO Add type for 'attributes' object. */
    private Object attributes;
    
    public PlaceDTO(Place place) {
        this.id = place.getId();
        this.url = place.getUrl();
        this.placeType = place.getPlaceType();
        this.name = place.getName();
        this.fullName = place.getFullName();
        this.countryCode = place.getCountryCode();
        this.country = place.getCountry();
        this.boundingBox = new BoundingBoxDTO(place.getBoundingBox());
        this.attributes = place.getAttributes();
    }
    
    @Override
    public String getId() {
        return id;
    }
    
    @Override
    public String getUrl() {
        return url;
    }
    
    @Override
    public String getPlaceType() {
        return placeType;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getFullName() {
        return fullName;
    }
    
    @Override
    public String getCountryCode() {
        return countryCode;
    }
    
    @Override
    public String getCountry() {
        return country;
    }
    
    @Override
    public BoundingBox getBoundingBox() {
        return boundingBox;
    }
    
    @Override
    public Object getAttributes() {
        return attributes;
    }
}
