package de.fjobilabs.twitter;

import java.util.List;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public interface ExtendedEntities {
    
    List<? extends MediaEntity> getMedia();
}
