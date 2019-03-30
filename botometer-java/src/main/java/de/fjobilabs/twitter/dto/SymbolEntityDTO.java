package de.fjobilabs.twitter.dto;

import de.fjobilabs.twitter.SymbolEntity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
//TODO Add ignoreUnknown=true
public class SymbolEntityDTO extends AbstractEntityDTO implements SymbolEntity {
    
    /*
     * All properties already exist in AbstractEntityDTO.
     */
    
    public SymbolEntityDTO(SymbolEntity symbolEntity) {
        super(symbolEntity);
    }
}
