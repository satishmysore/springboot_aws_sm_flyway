package com.satish.awsrds.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @author - Satish R
 */

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
