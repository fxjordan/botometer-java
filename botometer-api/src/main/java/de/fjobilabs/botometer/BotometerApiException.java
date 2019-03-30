package de.fjobilabs.botometer;

import java.util.Objects;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class BotometerApiException extends BotometerException {
    
    private int statusCode;
    private ApiError apiError;
    
    private BotometerApiException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
    
    private BotometerApiException(String message, Throwable cause, int statusCode) {
        super(message, cause);
    }
    
    private BotometerApiException(String message, int statusCode, ApiError apiError) {
        super(message);
        this.apiError = apiError;
    }
    
    private BotometerApiException(String message, Throwable cause, int statusCode, ApiError apiError) {
        super(message);
        this.apiError = apiError;
    }
    
    public int getStatusCode() {
        return statusCode;
    }
    
    public boolean hasApiError() {
        return this.apiError != null;
    }
    
    public ApiError getApiError() {
        return apiError;
    }
    
    public static BotometerApiException create(int statusCode) {
        Objects.requireNonNull(statusCode, "statusCode must not be null");
        return new BotometerApiException("API error (statusCode: " + statusCode + ")", statusCode);
    }
    
    public static BotometerApiException create(int statusCode, Throwable cause) {
        Objects.requireNonNull(statusCode, "statusCode must not be null");
        return new BotometerApiException("API error (statusCode: " + statusCode + ")", cause, statusCode);
    }
    
    public static BotometerApiException create(int statusCode, ApiError apiError) {
        Objects.requireNonNull(apiError, "apiError must not be null");
        return new BotometerApiException("API error (statusCode: " + statusCode + "): " + apiError.getError() + " - " + apiError.getMessage(),
            statusCode, apiError);
    }
    
    public static BotometerApiException create(int statusCode, ApiError apiError, Throwable cause) {
        Objects.requireNonNull(apiError, "apiError must not be null");
        return new BotometerApiException("API error (statusCode=" + statusCode + "): " + apiError.getError() + " - " + apiError.getMessage(),
            cause, statusCode, apiError);
    }
}
