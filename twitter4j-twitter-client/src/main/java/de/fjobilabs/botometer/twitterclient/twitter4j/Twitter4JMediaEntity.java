/*
 * Copyright 2019 FJOBI Labs Softwareentwicklung - Felix Jordan
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     https://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.fjobilabs.botometer.twitterclient.twitter4j;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.fjobilabs.twitter.MediaEntity;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
class Twitter4JMediaEntity extends AbstractTwitter4JEntity implements MediaEntity {
    
    private static final Logger logger = LoggerFactory.getLogger(Twitter4JMediaEntity.class);
    
    private twitter4j.MediaEntity mediaEntity;
    
    Twitter4JMediaEntity(twitter4j.MediaEntity mediaEntity) {
        super(mediaEntity);
        this.mediaEntity = mediaEntity;
    }
    
    @Override
    public String getDisplayURL() {
        return this.mediaEntity.getDisplayURL();
    }
    
    @Override
    public String getExpandedURL() {
        return this.mediaEntity.getExpandedURL();
    }
    
    @Override
    public long getId() {
        return this.mediaEntity.getId();
    }
    
    @Override
    public String getMediaURL() {
        return this.mediaEntity.getMediaURL();
    }
    
    @Override
    public String getMediaURLHttps() {
        return this.mediaEntity.getMediaURLHttps();
    }
    
    @Override
    public Sizes getSizes() {
        if (this.mediaEntity == null) {
            return null;
        }
        return new Twitter4JSizes(this.mediaEntity.getSizes());
    }
    
    @Override
    public long getSourceStatusId() {
        logger.trace("MediaEntity.getReplyCount() called, but not impemented by Twitter4JMediaEntity");
        return 0;
    }
    
    @Override
    public String getType() {
        return this.mediaEntity.getType();
    }
    
    @Override
    public String getURL() {
        return this.mediaEntity.getURL();
    }
    
    /**
     * @since 0.1.0
     * @author Felix Jordan
     */
    static class Twitter4JSizes implements Sizes {
        
        private Map<Integer, twitter4j.MediaEntity.Size> sizes;
        
        Twitter4JSizes(Map<Integer, twitter4j.MediaEntity.Size> sizes) {
            this.sizes = sizes;
        }
        
        @Override
        public Size getThumb() {
            return getSize(twitter4j.MediaEntity.Size.THUMB);
        }
        
        @Override
        public Size getLarge() {
            return getSize(twitter4j.MediaEntity.Size.LARGE);
        }
        
        @Override
        public Size getMedium() {
            return getSize(twitter4j.MediaEntity.Size.MEDIUM);
        }
        
        @Override
        public Size getSmall() {
            return getSize(twitter4j.MediaEntity.Size.SMALL);
        }
        
        private Size getSize(int sizeId) {
            if (this.sizes.containsKey(sizeId)) {
                return new Twitter4JSize(this.sizes.get(sizeId));
            }
            return null;
        }
        
        /**
         * @since 0.1.0
         * @author Felix Jordan
         */
        static class Twitter4JSize implements Size {
            
            private twitter4j.MediaEntity.Size size;
            
            Twitter4JSize(twitter4j.MediaEntity.Size size) {
                this.size = size;
            }
            
            @Override
            public int getWidth() {
                return this.size.getWidth();
            }
            
            @Override
            public int getHeight() {
                return this.size.getHeight();
            }
            
            @Override
            public String getResize() {
                return this.size.getResize() == twitter4j.MediaEntity.Size.FIT ? "fit" : "crop";
            }
        }
    }
}
