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

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import de.fjobilabs.twitter.ExtendedEntities;
import de.fjobilabs.twitter.MediaEntity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtendedEntitiesDTO implements ExtendedEntities {
    
    private List<MediaEntityDTO> media;
    
    public ExtendedEntitiesDTO(ExtendedEntities extendedEntities) {
        if (extendedEntities.getMedia() != null) {
            this.media = extendedEntities.getMedia().stream().map(MediaEntityDTO::new).collect(Collectors.toList());
        }
    }
    
    @Override
    public List<? extends MediaEntity> getMedia() {
        return media;
    }
}
