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

import de.fjobilabs.botometer.api.BotometerClientFactory;
import de.fjobilabs.botometer.twitterclient.TwitterClientFactory;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class BotometerConfigurationBuilder {
    
    private BotometerClientFactory botometerClientFactory;
    private TwitterClientFactory twitterClientFactory;
    private String botometerApiKey;
    private String twitterConsumerKey;
    private String twitterConsumerSecret;
    private String twitterAccessToken;
    private String twitterAccessTokenSecret;
    
    public BotometerConfigurationBuilder() {
    }
    
    public BotometerConfigurationBuilder(BotometerConfiguration configuration) {
        this.botometerClientFactory = configuration.getBotometerClientFactory();
        this.twitterClientFactory = configuration.getTwitterClientFactory();
        this.botometerApiKey = configuration.getBotometerApiKey();
        this.twitterConsumerKey = configuration.getTwitterConsumerKey();
        this.twitterConsumerSecret = configuration.getTwitterConsumerSecret();
        this.twitterAccessToken = configuration.getTwitterAccessToken();
        this.twitterAccessTokenSecret = configuration.getTwitterAccessTokenSecret();
    }
    
    public BotometerConfigurationBuilder botometerClientFactory(BotometerClientFactory botometerClientFactory) {
        this.botometerClientFactory = botometerClientFactory;
        return this;
    }
    
    public BotometerConfigurationBuilder twitterClientFactory(TwitterClientFactory twitterClientFactory) {
        this.twitterClientFactory = twitterClientFactory;
        return this;
    }
    
    public BotometerConfigurationBuilder botometerApiKey(String apikey) {
        this.botometerApiKey = apikey;
        return this;
    }
    
    public BotometerConfigurationBuilder twitterConsumerKey(String consumerKey) {
        this.twitterConsumerKey = consumerKey;
        return this;
    }
    
    public BotometerConfigurationBuilder twitterConsumerSecret(String consumerSecret) {
        this.twitterConsumerSecret = consumerSecret;
        return this;
    }
    
    public BotometerConfigurationBuilder twitterAccessToken(String accessToken) {
        this.twitterAccessToken = accessToken;
        return this;
    }
    
    public BotometerConfigurationBuilder twitterAccessTokenSecret(String accessTokenSecret) {
        this.twitterAccessTokenSecret = accessTokenSecret;
        return this;
    }
    
    public BotometerConfiguration build() {
        BotometerConfiguration configuration = new BotometerConfiguration(this.botometerClientFactory,
            this.twitterClientFactory, this.botometerApiKey, this.twitterConsumerKey, this.twitterConsumerSecret,
            this.twitterAccessToken, this.twitterAccessTokenSecret);
        
        configuration.validate();
        return configuration;
    }
}
