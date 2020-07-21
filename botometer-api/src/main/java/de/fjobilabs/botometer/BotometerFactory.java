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

import de.fjobilabs.botometer.api.BotometerClient;
import de.fjobilabs.botometer.api.BotometerClientFactory;
import de.fjobilabs.botometer.support.ServiceLoaderBotometerClientFactory;
import de.fjobilabs.botometer.support.ServiceLoaderTwitterClientFactory;
import de.fjobilabs.botometer.twitterclient.TwitterClient;
import de.fjobilabs.botometer.twitterclient.TwitterClientFactory;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class BotometerFactory {
    
    private BotometerConfiguration configuration;
    private BotometerClientFactory defaultBotometerClientFactory;
    private TwitterClientFactory defaultTwitterClientFactory;
    
    public BotometerFactory(BotometerConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException("configuraton must not be null");
        }
        configuration.validate();
        this.configuration = configuration;
    }
    
    public Botometer create() {
        return this.createFromConfiguration(this.configuration);
    }
    
    public Botometer create(String twitterAccessToken, String twitterAccessTokeSecret) {
        if (twitterAccessToken == null) {
            throw new IllegalArgumentException("twitterAccessToken must not be null");
        }
        if (twitterAccessTokeSecret == null) {
            throw new IllegalArgumentException("twitterAccessTokenSecret must not be null");
        }
        
        BotometerConfiguration configuration = new BotometerConfiguration(this.configuration);
        configuration.setTwitterAccessToken(twitterAccessToken);
        configuration.setTwitterAccessTokenSecret(twitterAccessTokeSecret);
        
        configuration.validate();
        
        return this.createFromConfiguration(configuration);
        
    }
    
    protected Botometer createFromConfiguration(BotometerConfiguration configuration) {
        BotometerClient botometerClient = createBotometerClient(configuration);
        
        /*
         * If we have an accessToken, all other twitter parameters are also set
         * and we can create a Twitter client.
         */
        if (configuration.hasTwitterAccessToken()) {
            TwitterClient twitterClient = createTwitterClient(configuration);
            return new AccountAnalyzingBotometer(botometerClient, twitterClient);
        } else  {
            return new BaseBotometer(botometerClient);
        }
    }
    
    protected BotometerClient createBotometerClient(BotometerConfiguration configuration) {
        BotometerClientFactory botometerClientFactory = this.configuration.getBotometerClientFactory();
        if (botometerClientFactory == null) {
            botometerClientFactory = getDefaultBotometerFactory();
        }
        return botometerClientFactory.createBotometerClient(
        		configuration.getBotometerCheckAccountsEndpoint(),
        		configuration.getBotometerApiKey());
    }
    
    protected TwitterClient createTwitterClient(BotometerConfiguration configuration) {
        TwitterClientFactory twitterClientFactory = this.configuration.getTwitterClientFactory();
        if (twitterClientFactory == null) {
            twitterClientFactory = getDefaultTwitterClientFactory();
        }
        return twitterClientFactory.createTwitterClient(configuration.getTwitterConsumerKey(),
            configuration.getTwitterConsumerSecret(), configuration.getTwitterAccessToken(),
            configuration.getTwitterAccessTokenSecret());
    }
    
    protected BotometerClientFactory getDefaultBotometerFactory() {
        if (this.defaultBotometerClientFactory == null) {
            this.defaultBotometerClientFactory = new ServiceLoaderBotometerClientFactory();
        }
        return this.defaultBotometerClientFactory;
    }
    
    protected TwitterClientFactory getDefaultTwitterClientFactory() {
        if (this.defaultTwitterClientFactory == null) {
            this.defaultTwitterClientFactory = new ServiceLoaderTwitterClientFactory();
        }
        return this.defaultTwitterClientFactory;
    }
}
