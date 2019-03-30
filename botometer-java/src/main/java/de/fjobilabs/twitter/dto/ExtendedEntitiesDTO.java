package de.fjobilabs.twitter.dto;

import java.util.List;
import java.util.stream.Collectors;

import de.fjobilabs.twitter.ExtendedEntities;
import de.fjobilabs.twitter.MediaEntity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class ExtendedEntitiesDTO implements ExtendedEntities {
    
    private List<MediaEntityDTO> media;
    
    public ExtendedEntitiesDTO(ExtendedEntities extendedEntities) {
        if (extendedEntities.getMedia() != null) {
            this.media = extendedEntities.getMedia().stream().map(MediaEntityDTO::new).collect(Collectors.toList());
        }
    }
    
    @Override
    public List<? extends MediaEntity> getMedia() {
        return media;
    }
}
