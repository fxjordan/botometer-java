package de.fjobilabs.botometer.dto;

import de.fjobilabs.botometer.Scores;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class ScoresDTO implements Scores {
    
    private float english;
    private float universal;
    
    public float getEnglish() {
        return english;
    }
    
    public float getUniversal() {
        return universal;
    }
}
