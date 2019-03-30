package de.fjobilabs.twitter.dto;

import de.fjobilabs.twitter.HashtagEntity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
// TODO Add ignoreUnknown=true
public class HashtagEntityDTO extends AbstractEntityDTO implements HashtagEntity {
    
    /*
     * All properties already exist in AbstractEntityDTO.
     */
    
    protected HashtagEntityDTO(HashtagEntity entity) {
        super(entity);
    }
}
