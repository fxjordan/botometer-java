package de.fjobilabs.twitter.dto;

import de.fjobilabs.twitter.BoundingBox;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
//TODO Add ignoreUnknown=true
public class BoundingBoxDTO implements BoundingBox {
    
    private float[][][] coordinates;
    private String type;
    
    public BoundingBoxDTO(BoundingBox boundingBox) {
        this.coordinates = boundingBox.getCoordinates();
        this.type = boundingBox.getType();
    }

    @Override
    public float[][][] getCoordinates() {
        return coordinates;
    }
    
    @Override
    public String getType() {
        return type;
    }
}
