package de.fjobilabs.twitter;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface MediaEntity extends Entity {
    
    @Override
    int getStartIndex();
    
    @Override
    int getEndIndex();
    
    /**
     * Returns the media URL text. This is the same value as {@link #getURL()}.
     *
     * @return The media URL text.
     */
    @Override
    String getText();
    
    String getDisplayURL();
    
    String getExpandedURL();
    
    long getId();
    
    String getMediaURL();
    
    String getMediaURLHttps();
    
    Sizes getSizes();
    
    long getSourceStatusId();
    
    String getType();
    
    String getURL();
    
    /**
     * @since 0.1.0
     * @author Felix Jordan
     */
    interface Sizes {
        
        Size getThumb();
        
        Size getLarge();
        
        Size getMedium();
        
        Size getSmall();
        
        /**
         * @since 0.1.0
         * @author Felix Jordan
         */
        interface Size {
            
            int getWidth();
            
            int getHeight();
            
            String getResize();
        }
    }
}
