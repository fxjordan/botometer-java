package de.fjobilabs.botometer.client;

import de.fjobilabs.botometer.BotometerException;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class BotometerClientException extends BotometerException {
    
    public BotometerClientException() {
        super();
    }
    
    public BotometerClientException(String message) {
        super(message);
    }
    
    public BotometerClientException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public BotometerClientException(Throwable cause) {
        super(cause);
    }
}
