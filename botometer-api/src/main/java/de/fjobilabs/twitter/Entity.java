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
package de.fjobilabs.twitter;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface Entity {
    
    /**
     * Returns the index of the first character of the entities text.
     * 
     * @return The start index.
     */
    int getStartIndex();
    
    /**
     * Returns the index of the first character <i>after</i> the entities text.
     * 
     * @return The end index.
     */
    int getEndIndex();
    
    /**
     * The entities text representation that is embedded into the Tweet. This
     * can be:
     * <ul>
     * <li>Name of the hashtag, minus the leading ‘#’ character</li>
     * <li>URL in a Tweet</li>
     * <li>Media URL in a Tweet</li>
     * <li>screen_name of a mentioned user (@mention)</li>
     * <li>Name of the cashhtag, minus the leading ‘$’ character</li>
     * </ul>
     * 
     * @return The entity text.
     */
    String getText();
}
