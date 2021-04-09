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
package de.fjobilabs.botometer.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

/**
 * @since 0.1.0
 * @author Felix Jordan
 */
public class ObjectMapperFactory {
    
    private static ObjectMapperFactory instance;
    
    private ObjectMapperFactory() {
    }
    
    public ObjectMapper create() {
        ObjectMapper objectMapper = new ObjectMapper();
        // We need snake case to translate User.screenName to screen_name etc.
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        // Modules for Java 8 time API support
        objectMapper.registerModules(new ParameterNamesModule(), new Jdk8Module(), new JavaTimeModule());
        return objectMapper;
    }
    
    public static ObjectMapperFactory getInstance() {
        if (instance == null) {
            instance = new ObjectMapperFactory();
        }
        return instance;
    }
}
