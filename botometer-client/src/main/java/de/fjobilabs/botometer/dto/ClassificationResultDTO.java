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
package de.fjobilabs.botometer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.fjobilabs.botometer.Categories;
import de.fjobilabs.botometer.ClassificationResult;
import de.fjobilabs.botometer.CompleteAutomationProbability;
import de.fjobilabs.botometer.Scores;
import de.fjobilabs.twitter.User;
import de.fjobilabs.twitter.dto.UserDTO;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClassificationResultDTO implements ClassificationResult {
    
    private CategoriesDTO categories;
    private UserDTO user;
    private ScoresDTO scores;
    private CompleteAutomationProbabilityDTO completeAutomationProbability;
    
    /*
     * TODO Add support for display_scores.
     */
    
    @Override
    public Categories getCategories() {
        return categories;
    }
    
    @Override
    public User getUser() {
        return user;
    }
    
    @Override
    public Scores getScores() {
        return scores;
    }
    
    @JsonProperty("cap")
    @Override
    public CompleteAutomationProbability getCompleteAutomationProbability() {
        return completeAutomationProbability;
    }
    
    @Override
    public String toString() {
        return "ClassificationResult(" + "user=" + this.user.getScreenName() + ", universalScore="
            + this.scores.getUniversal() + ", englishScore=" + this.scores.getEnglish() + ", universalCAP="
            + this.completeAutomationProbability.getUniversal() + ", englishCAP="
            + this.completeAutomationProbability.getEnglish() + ")";
    }
}
