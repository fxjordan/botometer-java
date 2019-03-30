package de.fjobilabs.twitter.dto;

import de.fjobilabs.twitter.BoundingBox;
import de.fjobilabs.twitter.Place;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class PlaceDTO implements Place {
    
    private String id;
    private String url;
    private String placeType;
    private String name;
    private String fullName;
    private String countryCode;
    private String country;
    private BoundingBoxDTO boundingBox;
    /* TODO Add type for 'attributes' object. */
    private Object attributes;
    
    public PlaceDTO(Place place) {
        this.id = place.getId();
        this.url = place.getUrl();
        this.placeType = place.getPlaceType();
        this.name = place.getName();
        this.fullName = place.getFullName();
        this.countryCode = place.getCountryCode();
        this.country = place.getCountry();
        this.boundingBox = new BoundingBoxDTO(place.getBoundingBox());
        this.attributes = place.getAttributes();
    }
    
    @Override
    public String getId() {
        return id;
    }
    
    @Override
    public String getUrl() {
        return url;
    }
    
    @Override
    public String getPlaceType() {
        return placeType;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getFullName() {
        return fullName;
    }
    
    @Override
    public String getCountryCode() {
        return countryCode;
    }
    
    @Override
    public String getCountry() {
        return country;
    }
    
    @Override
    public BoundingBox getBoundingBox() {
        return boundingBox;
    }
    
    @Override
    public Object getAttributes() {
        return attributes;
    }
}
