package de.fjobilabs.botometer;

/*
 * Somehow the aggregate-jar plugin fail with
 * href="https://botometer.iuni.iu.edu/#!/faq#what-is-cap", so we cut off the
 * '#what-i-cap'.
 */
/**
 * 
 * @see <a href="https://botometer.iuni.iu.edu/#!/faq" target=
 *      "_top">https://botometer.iuni.iu.edu/#!/faq#what-is-cap</a>
 * 
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface CompleteAutomationProbability {
    
    float getEnglish();
    
    float getUniversal();
}
