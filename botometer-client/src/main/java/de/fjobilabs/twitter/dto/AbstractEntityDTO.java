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

import de.fjobilabs.twitter.Entity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public abstract class AbstractEntityDTO implements Entity {
    
    private int[] indices;
    private String text;
    
    /* For serialisation. */
    AbstractEntityDTO(int[] indices, String text) {
        if (indices.length != 2) {
            throw new IllegalArgumentException("indices.length must be 2");
        }
        this.indices = new int[] {indices[0], indices[1]};
        this.text = text;
    }
    
    protected AbstractEntityDTO(Entity entity) {
        this.indices = new int[] {entity.getStartIndex(), entity.getEndIndex()};
        this.text = entity.getText();
    }
    
    /* Not a property of 'Entity' */
    public int[] getIndices() {
        return indices;
    }
    
    /* No attribute of the actual resource. */
    @JsonIgnore
    @Override
    public int getStartIndex() {
        return this.indices[0];
    }
    
    /* No attribute of the actual resource. */
    @JsonIgnore
    @Override
    public int getEndIndex() {
        return this.indices[1];
    }
    
    @Override
    public String getText() {
        return text;
    }
}
