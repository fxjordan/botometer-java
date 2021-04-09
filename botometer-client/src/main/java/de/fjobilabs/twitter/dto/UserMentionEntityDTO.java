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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.fjobilabs.twitter.UserMentionEntity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserMentionEntityDTO extends AbstractEntityDTO implements UserMentionEntity {
    
    private long id;
    private String idStr;
    private String name;
    
    @JsonCreator
    public UserMentionEntityDTO(@JsonProperty("indices") int[] indices, @JsonProperty("screen_name") String screenName,
        @JsonProperty("id") long id, @JsonProperty("id_str") String idStr, @JsonProperty("name") String name) {
        super(indices, screenName);
        this.id = id;
        this.idStr = idStr;
        this.name = name;
    }
    
    public UserMentionEntityDTO(UserMentionEntity userMentionEntity) {
        super(userMentionEntity);
        this.id = userMentionEntity.getId();
        this.idStr = Long.toString(userMentionEntity.getId());
        this.name = userMentionEntity.getName();
    }
    
    @Override
    public long getId() {
        return id;
    }
    
    /* Not a property of 'UserMentionEntity' */
    public String getIdStr() {
        return idStr;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    /*
     * The 'screen_name' attribute is already mapped through the #getText()
     * getter.
     */
    @JsonIgnore
    @Override
    public String getScreenName() {
        return super.getText();
    }
    
    /*
     * User Mention Entity has o 'text' attribute. This is the same value as the
     * 'screen_name' attribute.
     */
    @JsonProperty("screen_name")
    @Override
    public String getText() {
        return super.getText();
    }
}
