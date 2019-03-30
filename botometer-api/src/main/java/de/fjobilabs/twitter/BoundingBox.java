package de.fjobilabs.twitter;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface BoundingBox {
    
    float[][][] getCoordinates();
    
    String getType();
}
