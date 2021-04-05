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

import de.fjobilabs.twitter.Rule;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RuleDTO implements Rule {
    
    private String tag;
    private long id;
    private String idStr;
    
    public RuleDTO(Rule rule) {
        this.tag = rule.getTag();
        this.id = rule.getId();
        this.idStr = Long.toString(rule.getId());
    }
    
    @Override
    public String getTag() {
        return tag;
    }
    
    @Override
    public long getId() {
        return id;
    }
    
    /* Not a property of 'Rule' */
    public String getIdStr() {
        return idStr;
    }
}
