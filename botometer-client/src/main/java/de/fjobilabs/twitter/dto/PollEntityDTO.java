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

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import de.fjobilabs.twitter.PollEntity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PollEntityDTO implements PollEntity {
    
    private List<OptionDTO> options;
    private Instant endTimestamp;
    private int durationMinutes; // Is this really int or String?
    
    public PollEntityDTO(PollEntity pollEntity) {
        this.options = pollEntity.getOptions().stream().map(OptionDTO::new).collect(Collectors.toList());
        this.endTimestamp = pollEntity.getEndTimestamp();
        this.durationMinutes = pollEntity.getDurationMinutes();
        
    }
    
    @Override
    public List<? extends Option> getOptions() {
        return options;
    }
    
    @Override
    public Instant getEndTimestamp() {
        return endTimestamp;
    }
    
    @Override
    public int getDurationMinutes() {
        return durationMinutes;
    }
    
    /**
     * @since 0.1.0
     * @author Felix Jordan
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OptionDTO implements Option {
        
        private int position;
        private String text;
        
        public OptionDTO(Option option) {
            this.position = option.getPosition();
            this.text = option.getText();
        }
        
        @Override
        public int getPosition() {
            return position;
        }
        
        @Override
        public String getText() {
            return text;
        }
    }
}
