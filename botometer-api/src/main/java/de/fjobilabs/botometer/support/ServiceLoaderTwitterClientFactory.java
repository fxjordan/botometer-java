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
package de.fjobilabs.botometer.support;

import java.util.ServiceLoader;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class ServiceLoaderTwitterClientFactory implements TwitterClientFactory {
    
    private ServiceLoader<TwitterClientFactory> serviceLoader;
    private TwitterClientFactory targetFactory;
    
    public ServiceLoaderTwitterClientFactory() {
        this.serviceLoader = ServiceLoader.load(TwitterClientFactory.class);
    }
    
    @Override
    public TwitterClient createTwitterClient(String consumerKey, String consumerSecret, String accessToken,
        String accessTokenSecret) {
        if (this.targetFactory == null) {
            this.targetFactory = loadFactory();
        }
        return this.targetFactory.createTwitterClient(consumerKey, consumerSecret, accessToken, accessTokenSecret);
    }
    
    private TwitterClientFactory loadFactory() {
        if (this.serviceLoader.iterator().hasNext()) {
            return this.serviceLoader.iterator().next();
        } else {
            throw new RuntimeException("ServiceLoader found no service implementation of TwitterClientFactory");
        }
    }
}
