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
