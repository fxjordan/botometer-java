package de.fjobilabs.twitter.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.fjobilabs.twitter.URLEntity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
// TODO Add ignoreUnknown=true
public class URLEntityDTO extends AbstractEntityDTO implements URLEntity {
    
    private String displayUrl;
    private String expandedUrl;
    
    /*
     * TODO Add 'unwound' attribute
     */
    
    /* For serialisation. */
    @JsonCreator
    public URLEntityDTO(
            @JsonProperty("indices") int[] indices,
            @JsonProperty("url") String url,
            @JsonProperty("display_url") String displayUrl,
            @JsonProperty("expanded_url") String expandedUrl) {
        super(indices, url);
        this.displayUrl = displayUrl;
        this.expandedUrl = expandedUrl;
    }
    
    public URLEntityDTO(URLEntity urlEntity) {
        super(urlEntity);
        this.displayUrl = urlEntity.getDisplayURL();
        this.expandedUrl = urlEntity.getExpandedURL();
    }
    
    @Override
    public String getDisplayURL() {
        return displayUrl;
    }
    
    @Override
    public String getExpandedURL() {
        return expandedUrl;
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
}
