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
package de.fjobilabs.botometer.twitterclient.twitter4j;

import java.util.List;
import java.util.stream.Collectors;

import de.fjobilabs.botometer.twitterclient.TwitterClient;
import de.fjobilabs.botometer.twitterclient.TwitterClientException;
import de.fjobilabs.twitter.Tweet;
import de.fjobilabs.twitter.User;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class Twitter4JTwitterClient implements TwitterClient {
    
    private Twitter twitter;
    
    public Twitter4JTwitterClient(Twitter twitter) {
        this.twitter = twitter;
    }
    
    @Override
    public User getUser(long userId) throws TwitterClientException {
        try {
            return new Twitter4JUser(this.twitter.showUser(userId));
        } catch (TwitterException e) {
            throw new TwitterClientException("Failed to get user for userId: " + userId, e);
        }
    }
    
    @Override
    public User getUser(String screenName) throws TwitterClientException {
        try {
            return new Twitter4JUser(this.twitter.showUser(screenName));
        } catch (TwitterException e) {
            throw new TwitterClientException("Failed to get user for screen name: " + screenName, e);
        }
    }
    
    @Override
    public List<Tweet> getUserTimeline(long userId, int count) throws TwitterClientException {
        Paging paging = new Paging();
        paging.setCount(count);
        try {
            return this.twitter.getUserTimeline(userId, paging).stream().map(Twitter4JTweet::new).collect(Collectors.toList());
        } catch (TwitterException e) {
            throw new TwitterClientException("Failed to get user timeline for userId: " + userId, e);
        }
    }
    
    @Override
    public List<Tweet> getUserTimeline(String screenName, int count) throws TwitterClientException {
        Paging paging = new Paging();
        paging.setCount(count);
        try {
            return this.twitter.getUserTimeline(screenName, paging).stream().map(Twitter4JTweet::new)
                .collect(Collectors.toList());
        } catch (TwitterException e) {
            throw new TwitterClientException("Failed to get user timeline for screenName: " + screenName, e);
        }
    }
    
    @Override
    public List<Tweet> search(String query, int count) throws TwitterClientException {
        try {
            return this.twitter.search(new Query(query).count(count)).getTweets().stream().map(Twitter4JTweet::new)
                .collect(Collectors.toList());
        } catch (TwitterException e) {
            throw new TwitterClientException("Failed to search tweets for query: " + query, e);
        }
    }
}
