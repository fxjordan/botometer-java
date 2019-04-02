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

import de.fjobilabs.botometer.AccountAnalysisResult;
import de.fjobilabs.botometer.api.BotometerClient;
import de.fjobilabs.botometer.api.BotometerOperations;
import de.fjobilabs.botometer.api.BotometerRawOperations;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
class BaseBotometer implements Botometer {
    
    protected final BotometerClient botometerClient;
    
    BaseBotometer(BotometerClient botometerClient) {
        this.botometerClient = botometerClient;
    }
    
    @Override
    public BotometerOperations getBotometerOperations() {
        return this.botometerClient.getBotometerOperations();
    }
    
    @Override
    public BotometerRawOperations getRawOperations() {
        return this.botometerClient.getRawOperations();
    }
    
    @Override
    public AccountAnalysisResult analyzeAccount(long userId) {
        throw new UnsupportedOperationException(
            "This Botometer instance is not configured to access data from Twitter. "
            + "You need to set all twitter* configuration properties and provide a TwitterClient implementation at runtime.");
    }
    
    @Override
    public AccountAnalysisResult analyzeAccount(String screenName) {
        throw new UnsupportedOperationException(
            "This Botometer instance is not configured to access data from Twitter. "
            + "You need to set all twitter* configuration properties and provide a TwitterClient implementation at runtime.");
    }
}
