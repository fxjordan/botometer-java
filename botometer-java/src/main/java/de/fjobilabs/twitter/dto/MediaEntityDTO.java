package de.fjobilabs.twitter.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.fjobilabs.twitter.MediaEntity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
// TODO Add ignoreUnknown=true
public class MediaEntityDTO extends AbstractEntityDTO implements MediaEntity {
    
    private String displayUrl;
    private String expandedUrl;
    private long id;
    private String idStr;
    private String mediaUrl;
    private String mediaUrlHttps;
    private SizesDTO sizes;
    private long sourceStatusId;
    private String sourceStatusIdStr;
    private String type;
    
    public MediaEntityDTO(MediaEntity mediaEntity) {
        super(mediaEntity);
        this.displayUrl = mediaEntity.getDisplayURL();
        this.expandedUrl = mediaEntity.getExpandedURL();
        this.id = mediaEntity.getId();
        this.idStr = Long.toString(mediaEntity.getId());
        this.mediaUrl = mediaEntity.getMediaURL();
        this.mediaUrlHttps = mediaEntity.getMediaURLHttps();
        this.sizes = new SizesDTO(mediaEntity.getSizes());
        this.sourceStatusId = mediaEntity.getSourceStatusId();
        this.sourceStatusIdStr = Long.toString(mediaEntity.getSourceStatusId());
        this.type = mediaEntity.getType();
    }
    
    @Override
    public String getDisplayURL() {
        return displayUrl;
    }
    
    @Override
    public String getExpandedURL() {
        return expandedUrl;
    }
    
    @Override
    public long getId() {
        return id;
    }
    
    /* Not a property of 'MediaEntity' */
    public String getIdStr() {
        return idStr;
    }
    
    @Override
    public String getMediaURL() {
        return mediaUrl;
    }
    
    @Override
    public String getMediaURLHttps() {
        return mediaUrlHttps;
    }
    
    @Override
    public Sizes getSizes() {
        return sizes;
    }
    
    @Override
    public long getSourceStatusId() {
        return sourceStatusId;
    }
    
    /* Not a property of 'MediaEntity' */
    public String getSourceStatusIdStr() {
        return sourceStatusIdStr;
    }
    
    @Override
    public String getType() {
        return type;
    }
    
    /* The 'url' attribute is already mapped through the #getText() getter. */
    @JsonIgnore
    @Override
    public String getURL() {
        return super.getText();
    }
    
    /*
     * URL Entity has o 'text' attribute. This is the same value as the 'url'
     * attribute.
     */
    @JsonProperty("url")
    @Override
    public String getText() {
        return super.getText();
    }
    
    /**
     * @since 0.1.0
     * @author Felix Jordan
     */
    // TODO Add ignoreUnknown=true
    public class SizesDTO implements Sizes {
        
        private SizeDTO thumb;
        private SizeDTO large;
        private SizeDTO medium;
        private SizeDTO small;
        
        public SizesDTO(Sizes sizes) {
            this.thumb = new SizeDTO(sizes.getThumb());
            this.large = new SizeDTO(sizes.getLarge());
            this.medium = new SizeDTO(sizes.getMedium());
            this.small = new SizeDTO(sizes.getSmall());
        }

        @Override
        public Size getThumb() {
            return thumb;
        }
        
        @Override
        public Size getLarge() {
            return large;
        }
        
        @Override
        public Size getMedium() {
            return medium;
        }
        
        @Override
        public Size getSmall() {
            return small;
        }
        
        /**
         * @since 0.1.0
         * @author Felix Jordan
         */
        // TODO Add ignoreUnknown=true
        public class SizeDTO implements Size {
            
            private int w;
            private int h;
            private String resize;
            
            public SizeDTO(Size size) {
                this.w = size.getWidth();
                this.h = size.getHeight();
                this.resize = size.getResize();
            }

            @JsonProperty("w")
            @Override
            public int getWidth() {
                return w;
            }
            
            @JsonProperty("h")
            @Override
            public int getHeight() {
                return h;
            }
            
            @Override
            public String getResize() {
                return resize;
            }
        }
    }
}
