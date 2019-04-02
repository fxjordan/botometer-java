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
package de.fjobilabs.botometer.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import de.fjobilabs.botometer.AccountData;
import de.fjobilabs.twitter.Tweet;
import de.fjobilabs.twitter.User;
import de.fjobilabs.twitter.dto.TweetDTO;
import de.fjobilabs.twitter.dto.UserDTO;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class AccountDataDTO implements AccountData {
    
    private UserDTO user;
    private List<TweetDTO> timeline;
    private List<TweetDTO> mentions;
    
    AccountDataDTO() {
    }
    
    public AccountDataDTO(UserDTO user, List<TweetDTO> timeline, List<TweetDTO> mentions) {
        Objects.requireNonNull(user, "user must not be null");
        Objects.requireNonNull(timeline, "timeline must not be null");
        Objects.requireNonNull(mentions, "mentions must not be null");
        this.user = user;
        this.timeline = Collections.unmodifiableList(new ArrayList<>(timeline));
        this.mentions = Collections.unmodifiableList(new ArrayList<>(mentions));
    }
    
    public AccountDataDTO(AccountData accountData) {
        this.user = new UserDTO(accountData.getUser());
        this.timeline = accountData.getTimeline().stream().map(TweetDTO::new).collect(Collectors.toList());
        this.mentions = accountData.getMentions().stream().map(TweetDTO::new).collect(Collectors.toList());
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
