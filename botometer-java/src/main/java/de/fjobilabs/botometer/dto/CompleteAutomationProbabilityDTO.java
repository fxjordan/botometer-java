package de.fjobilabs.botometer.dto;

import de.fjobilabs.botometer.CompleteAutomationProbability;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class CompleteAutomationProbabilityDTO implements CompleteAutomationProbability {
    
    private float english;
    private float universal;
    
    @Override
    public float getEnglish() {
        return english;
    }
    
    @Override
    public float getUniversal() {
        return universal;
    }
}
