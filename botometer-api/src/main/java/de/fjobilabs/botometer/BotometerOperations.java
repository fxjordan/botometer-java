package de.fjobilabs.botometer;

import java.io.IOException;
import java.util.List;

import de.fjobilabs.twitter.Tweet;
import de.fjobilabs.twitter.User;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface BotometerOperations {
    
    ClassificationResult checkAccount(AccountData accountData) throws BotometerException, IOException;
    
    ClassificationResult checkAccount(User user, List<Tweet> timeline, List<Tweet> mentions) throws BotometerException, IOException;
}
