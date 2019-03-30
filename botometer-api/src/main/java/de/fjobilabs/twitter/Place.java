package de.fjobilabs.twitter;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface Place {
    
    String getId();
    
    String getUrl();
    
    String getPlaceType();
    
    String getName();
    
    String getFullName();
    
    String getCountryCode();
    
    String getCountry();
    
    BoundingBox getBoundingBox();
    
    Object getAttributes();
}
