package de.fjobilabs.botometer;

import java.io.IOException;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface BotometerRawOperations {
    
    ClassificationResult checkAccount(String accountDataJson) throws BotometerException, IOException;
    
    ClassificationResult checkAccount(byte[] accountDataJson) throws BotometerException, IOException;
    
    ClassificationResult checkAccount(String userJson, String timelineJson, String mentionsJson) throws BotometerException, IOException;
    
    ClassificationResult checkAccount(byte[] userJson, byte[] timelineJson, byte[] mentionsJson) throws BotometerException, IOException;
}
