package de.fjobilabs.botometer.dto;

import de.fjobilabs.botometer.Categories;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class CategoriesDTO implements Categories {
    
    private float friend;
    private float sentiment;
    private float temporal;
    private float user;
    private float network;
    private float content;
    
    public float getFriend() {
        return friend;
    }
    
    public float getSentiment() {
        return sentiment;
    }
    
    public float getTemporal() {
        return temporal;
    }
    
    public float getUser() {
        return user;
    }
    
    public float getNetwork() {
        return network;
    }
    
    public float getContent() {
        return content;
    }
}
