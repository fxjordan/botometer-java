package de.fjobilabs.twitter;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface UserMentionEntity extends Entity {
    
    @Override
    int getStartIndex();
    
    @Override
    int getEndIndex();
    
    /**
     * Returns the mentioned screen_name. This is the same value as {@link #getScreenName()}.
     *
     * @return The mentioned screen_name.
     */
    @Override
    String getText();
    
    long getId();
    
    String getName();
    
    String getScreenName();
    
}
