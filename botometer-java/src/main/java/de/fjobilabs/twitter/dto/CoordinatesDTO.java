package de.fjobilabs.twitter.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.fjobilabs.twitter.Coordinates;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
// TODO Add ignoreUnknown=true
public class CoordinatesDTO implements Coordinates {
    
    private float[] coordinates;
    private String type;
    
    public CoordinatesDTO(Coordinates coordinates) {
        this.coordinates = new float[] {coordinates.getLatitude(), coordinates.getLongitude()};
        this.type = coordinates.getType();
    }
    
    /* Not a property of 'Coordinates' */
    public float[] getCoordinates() {
        return coordinates;
    }
    
    /* No attribute of the actual resource. */
    @JsonIgnore
    @Override
    public float getLongitude() {
        if (this.coordinates.length != 2) {
            throw new IllegalStateException("coordinates array not valid! coordinates.length must be 2");
        }
        return this.coordinates[0];
    }
    
    /* No attribute of the actual resource. */
    @JsonIgnore
    @Override
    public float getLatitude() {
        if (this.coordinates.length != 2) {
            throw new IllegalStateException("coordinates array not valid! coordinates.length must be 2");
        }
        return this.coordinates[1];
    }
    
    @Override
    public String getType() {
        return type;
    }
}
