package org.geeksforgeeks.digitallibrary.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurations {

    @Bean
    public ObjectMapper getMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
