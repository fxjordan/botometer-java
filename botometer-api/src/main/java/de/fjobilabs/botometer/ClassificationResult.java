package de.fjobilabs.botometer;

import de.fjobilabs.twitter.User;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface ClassificationResult {
    
    Categories getCategories();
    
    User getUser();
    
    Scores getScores();
    
    CompleteAutomationProbability getCompleteAutomationProbability();
    
    /*
     * TODO Add support for display_scores.
     */
}
