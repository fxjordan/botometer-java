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
package de.fjobilabs.botometer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import de.fjobilabs.botometer.Categories;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoriesDTO implements Categories {
    
    private float friend;
    private float sentiment;
    private float temporal;
    private float user;
    private float network;
    private float content;
    
    public float getFriend() {
        return friend;
    }
    
    public float getSentiment() {
        return sentiment;
    }
    
    public float getTemporal() {
        return temporal;
    }
    
    public float getUser() {
        return user;
    }
    
    public float getNetwork() {
        return network;
    }
    
    public float getContent() {
        return content;
    }
}
