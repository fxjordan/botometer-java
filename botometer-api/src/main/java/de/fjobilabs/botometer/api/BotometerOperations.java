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
package de.fjobilabs.botometer.api;

import java.io.IOException;
import java.util.List;

import de.fjobilabs.botometer.AccountData;
import de.fjobilabs.botometer.BotometerException;
import de.fjobilabs.botometer.ClassificationResult;
import de.fjobilabs.twitter.Tweet;
import de.fjobilabs.twitter.User;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface BotometerOperations {
    
    ClassificationResult checkAccount(AccountData accountData) throws BotometerException, IOException;
    
    ClassificationResult checkAccount(User user, List<Tweet> timeline, List<Tweet> mentions)
        throws BotometerException, IOException;
}
