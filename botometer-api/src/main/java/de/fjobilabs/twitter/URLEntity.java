package de.fjobilabs.twitter;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface URLEntity extends Entity {
    
    @Override
    int getStartIndex();
    
    @Override
    int getEndIndex();
    
    /**
     * Returns the URL text. This is the same value as {@link #getURL()}.
     *
     * @return The URL text.
     */
    @Override
    String getText();
    
    String getDisplayURL();
    
    String getExpandedURL();
    
    String getURL();
}
