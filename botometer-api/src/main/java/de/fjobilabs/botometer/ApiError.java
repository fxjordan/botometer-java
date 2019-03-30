package de.fjobilabs.botometer;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class ApiError {
    
    private String error;
    private String message;
    
    /*
     * Constructor for deserialization.
     */
    ApiError() {
    }
    
    public ApiError(String error, String message) {
        this.error = error;
        this.message = message;
    }
    
    public String getError() {
        return error;
    }
    
    public String getMessage() {
        return message;
    }
}
