package de.fjobilabs.twitter;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface HashtagEntity extends Entity {
    
    @Override
    int getStartIndex();
    
    @Override
    int getEndIndex();
    
    /**
     * Returns the name of the hashtag without #.
     *
     * @return The text of the hashtag
     */
    @Override
    String getText();
}
