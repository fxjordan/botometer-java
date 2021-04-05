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
package de.fjobilabs.botometer;

import java.io.IOException;
import java.util.List;

import de.fjobilabs.botometer.api.BotometerClient;
import de.fjobilabs.botometer.twitterclient.TwitterClient;
import de.fjobilabs.botometer.twitterclient.TwitterClientException;
import de.fjobilabs.twitter.Tweet;
import de.fjobilabs.twitter.User;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
class AccountAnalyzingBotometer extends BaseBotometer implements Botometer {
    
    private static final int TIMELINE_TWEET_COUNT = 200;
    private static final int MENTIONS_TWEET_COUNT = 100;
    
    private final TwitterClient twitterClient;
    
    AccountAnalyzingBotometer(BotometerClient botometerClient, TwitterClient twitterClient) {
        super(botometerClient);
        this.twitterClient = twitterClient;
    }
    
    @Override
    public AccountAnalysisResult analyzeAccount(long userId) throws BotometerException {
        User user;
        List<Tweet> timeline;
        List<Tweet> mentions;
        try {
            user = this.twitterClient.getUser(userId);
            timeline = this.twitterClient.getUserTimeline(userId, TIMELINE_TWEET_COUNT);
            mentions = getMentions(user.getScreenName());
        } catch (TwitterClientException e) {
            throw new BotometerException("Failed to load account data", e);
        }
        
        return analyzeAccountData(user, timeline, mentions);
    }
    
    @Override
    public AccountAnalysisResult analyzeAccount(String screenName) throws BotometerException {
        User user;
        List<Tweet> timeline;
        List<Tweet> mentions;
        try {
            user = this.twitterClient.getUser(screenName);
            timeline = this.twitterClient.getUserTimeline(screenName, TIMELINE_TWEET_COUNT);
            mentions = getMentions(screenName);
        } catch (TwitterClientException e) {
            throw new BotometerException("Failed to load account data", e);
        }
        
        return analyzeAccountData(user, timeline, mentions);
    }
    
    private List<Tweet> getMentions(String screenName) throws TwitterClientException {
        return this.twitterClient.search("@" + screenName, MENTIONS_TWEET_COUNT);
    }
    
    private AccountAnalysisResult analyzeAccountData(User user, List<Tweet> timeline, List<Tweet> mentions)
        throws BotometerException {
        ClassificationResult classificationResult;
        try {
            classificationResult = this.botometerClient.getBotometerOperations().checkAccount(user, timeline, mentions);
        } catch (BotometerException e) {
            throw new BotometerException("Botometer failed to analyze account data", e);
        } catch (IOException e) {
            throw new BotometerException("IOException while analyzing account data", e);
        }
        return new AccountAnalysisResultImpl(classificationResult, timeline, mentions);
    }
    
    /**
     * @since 0.1.0
     * @author Felix Jordan
     */
    private static class AccountAnalysisResultImpl implements AccountAnalysisResult {
        
        private ClassificationResult classificationResult;
        private AccountData accountData;
        
        private AccountAnalysisResultImpl(ClassificationResult classificationResult, List<Tweet> timeline, List<Tweet> mentions) {
            this.classificationResult = classificationResult;
            this.accountData = new AccountDataImpl(classificationResult.getUser(), timeline, mentions);
        }
        
        @Override
        public Categories getCategories() {
            return this.classificationResult.getCategories();
        }
        
        @Override
        public Scores getScores() {
            return this.classificationResult.getScores();
        }
        
        @Override
        public CompleteAutomationProbability getCompleteAutomationProbability() {
            return this.classificationResult.getCompleteAutomationProbability();
        }
        
        @Override
        public DisplayScores getDisplayScores() {
            return this.classificationResult.getDisplayScores();
        }
        
        @Override
        public User getUser() {
            return this.classificationResult.getUser();
        }
        
        @Override
        public AccountData getAccountData() {
            return accountData;
        }
        
        @Override
        public String toString() {
            return "AccountAnalysisResult(" + "user=" + getUser().getScreenName() + ", universalScore="
                + getScores().getUniversal() + ", englishScore=" + getScores().getEnglish() + ", universalCAP="
                + getCompleteAutomationProbability().getUniversal() + ", englishCAP="
                + getCompleteAutomationProbability().getEnglish() + ")";
        }
        
        private static class AccountDataImpl implements AccountData {
            
            private User user;
            private List<Tweet> timeline;
            private List<Tweet> mentions;
            
            private AccountDataImpl(User user, List<Tweet> timeline, List<Tweet> mentions) {
                this.user = user;
                this.timeline = timeline;
                this.mentions = mentions;
            }

            @Override
            public User getUser() {
                return user;
            }

            @Override
            public List<? extends Tweet> getTimeline() {
                return timeline;
            }

            @Override
            public List<? extends Tweet> getMentions() {
                return mentions;
            }
        }
    }
}
