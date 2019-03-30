package de.fjobilabs.twitter.dto;

import java.util.List;
import java.util.stream.Collectors;

import de.fjobilabs.twitter.Entities;
import de.fjobilabs.twitter.HashtagEntity;
import de.fjobilabs.twitter.MediaEntity;
import de.fjobilabs.twitter.PollEntity;
import de.fjobilabs.twitter.SymbolEntity;
import de.fjobilabs.twitter.URLEntity;
import de.fjobilabs.twitter.UserMentionEntity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class EntitiesDTO implements Entities {
    
    private List<HashtagEntityDTO> hashtags;
    private List<MediaEntityDTO> media;
    private List<URLEntityDTO> urls;
    private List<UserMentionEntityDTO> userMentions;
    private List<SymbolEntityDTO> symbols;
    private List<PollEntityDTO> polls;
    
    /* For serialisation. */
    EntitiesDTO() {
    }
    
    public EntitiesDTO(Entities entities) {
        if (entities.getHashtags() != null) {
            this.hashtags = entities.getHashtags().stream().map(HashtagEntityDTO::new).collect(Collectors.toList());
        }
        if (entities.getMedia() != null) {
            this.media = entities.getMedia().stream().map(MediaEntityDTO::new).collect(Collectors.toList());
        }
        if (entities.getUrls() != null) {
            this.urls = entities.getUrls().stream().map(URLEntityDTO::new).collect(Collectors.toList());
        }
        if (entities.getUserMentions() != null) {
            this.userMentions = entities.getUserMentions().stream().map(UserMentionEntityDTO::new)
                .collect(Collectors.toList());
        }
        if (entities.getSymbols() != null) {
            this.symbols = entities.getSymbols().stream().map(SymbolEntityDTO::new).collect(Collectors.toList());
        }
        if (entities.getPolls() != null) {
            this.polls = entities.getPolls().stream().map(PollEntityDTO::new).collect(Collectors.toList());
        }
    }
    
    @Override
    public List<? extends HashtagEntity> getHashtags() {
        return hashtags;
    }
    
    @Override
    public List<? extends MediaEntity> getMedia() {
        return media;
    }
    
    @Override
    public List<? extends URLEntity> getUrls() {
        return urls;
    }
    
    @Override
    public List<? extends UserMentionEntity> getUserMentions() {
        return userMentions;
    }
    
    @Override
    public List<? extends SymbolEntity> getSymbols() {
        return symbols;
    }
    
    @Override
    public List<? extends PollEntity> getPolls() {
        return polls;
    }
}
