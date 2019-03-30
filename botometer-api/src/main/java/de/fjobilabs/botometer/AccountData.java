package de.fjobilabs.botometer;

import java.util.List;

import de.fjobilabs.twitter.Tweet;
import de.fjobilabs.twitter.User;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface AccountData {
    
    User getUser();
    
    List<? extends Tweet> getTimeline();
    
    List<? extends Tweet> getMentions();
}
