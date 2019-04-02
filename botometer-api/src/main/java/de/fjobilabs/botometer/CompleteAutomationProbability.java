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
package de.fjobilabs.botometer;

/*
 * Somehow the aggregate-jar plugin fail with
 * href="https://botometer.iuni.iu.edu/#!/faq#what-is-cap", so we cut off the
 * '#what-i-cap'.
 */
/**
 * 
 * @see <a href="https://botometer.iuni.iu.edu/#!/faq" target=
 *      "_top">https://botometer.iuni.iu.edu/#!/faq#what-is-cap</a>
 * 
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface CompleteAutomationProbability {
    
    float getEnglish();
    
    float getUniversal();
}
