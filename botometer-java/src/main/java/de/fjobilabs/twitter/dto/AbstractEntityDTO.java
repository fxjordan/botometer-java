package de.fjobilabs.twitter.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.fjobilabs.twitter.Entity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public abstract class AbstractEntityDTO implements Entity {
    
    private int[] indices;
    private String text;
    
    /* For serialisation. */
    AbstractEntityDTO(int[] indices, String text) {
        if (indices.length != 2) {
            throw new IllegalArgumentException("indices.length must be 2");
        }
        this.indices = new int[] {indices[0], indices[1]};
        this.text = text;
    }
    
    protected AbstractEntityDTO(Entity entity) {
        this.indices = new int[] {entity.getStartIndex(), entity.getEndIndex()};
        this.text = entity.getText();
    }
    
    /* Not a property of 'Entity' */
    public int[] getIndices() {
        return indices;
    }
    
    /* No attribute of the actual resource. */
    @JsonIgnore
    @Override
    public int getStartIndex() {
        return this.indices[0];
    }
    
    /* No attribute of the actual resource. */
    @JsonIgnore
    @Override
    public int getEndIndex() {
        return this.indices[1];
    }
    
    @Override
    public String getText() {
        return text;
    }
}
