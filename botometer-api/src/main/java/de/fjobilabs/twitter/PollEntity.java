package de.fjobilabs.twitter;

import java.time.Instant;
import java.util.List;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface PollEntity {
    
    List<? extends Option> getOptions();
    
    Instant getEndTimestamp();
    
    int getDurationMinutes();
    
    /**
     * @since 0.1.0
     * @author Felix Jordan
     */
    interface Option {
        
        int getPosition();
        
        String getText();
    }
}
