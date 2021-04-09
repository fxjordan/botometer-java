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
package de.fjobilabs.botometer.twitterclient.twitter4j;

import de.fjobilabs.botometer.twitterclient.TwitterClient;
import de.fjobilabs.botometer.twitterclient.TwitterClientFactory;

import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class Twitter4JTwitterClientFactory implements TwitterClientFactory {
    
    @Override
    public TwitterClient createTwitterClient(String consumerKey, String consumerSecret, String accessToken,
        String accessTokenSecret) {
        Configuration configuration = new ConfigurationBuilder()
            .setIncludeMyRetweetEnabled(true)
            .setOAuthConsumerKey(consumerKey)
            .setOAuthConsumerSecret(consumerSecret)
            .setOAuthAccessToken(accessToken)
            .setOAuthAccessTokenSecret(accessTokenSecret).build();
        return new Twitter4JTwitterClient(new TwitterFactory(configuration).getInstance());
    }
}
