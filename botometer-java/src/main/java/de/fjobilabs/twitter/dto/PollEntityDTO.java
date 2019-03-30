package de.fjobilabs.twitter.dto;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import de.fjobilabs.twitter.PollEntity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
//TODO Add ignoreUnknown=true
public class PollEntityDTO implements PollEntity {
    
    private List<OptionDTO> options;
    private Instant endTimestamp;
    private int durationMinutes; // Is this really int or String?
    
    public PollEntityDTO(PollEntity pollEntity) {
        this.options = pollEntity.getOptions().stream().map(OptionDTO::new).collect(Collectors.toList());
        this.endTimestamp = pollEntity.getEndTimestamp();
        this.durationMinutes = pollEntity.getDurationMinutes();
        
    }
    
    @Override
    public List<? extends Option> getOptions() {
        return options;
    }
    
    @Override
    public Instant getEndTimestamp() {
        return endTimestamp;
    }
    
    @Override
    public int getDurationMinutes() {
        return durationMinutes;
    }
    
    /**
     * @since 0.1.0
     * @author Felix Jordan
     */
    //TODO Add ignoreUnknown=true
    public static class OptionDTO implements Option {
        
        private int position;
        private String text;
        
        public OptionDTO(Option option) {
            this.position = option.getPosition();
            this.text = option.getText();
        }
        
        @Override
        public int getPosition() {
            return position;
        }
        
        @Override
        public String getText() {
            return text;
        }
    }
}
