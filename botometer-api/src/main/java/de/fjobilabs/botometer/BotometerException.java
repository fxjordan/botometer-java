package de.fjobilabs.botometer;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class BotometerException extends RuntimeException {
    
    public BotometerException() {
        super();
    }
    
    public BotometerException(String message) {
        super(message);
    }
    
    public BotometerException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public BotometerException(Throwable cause) {
        super(cause);
    }
}
