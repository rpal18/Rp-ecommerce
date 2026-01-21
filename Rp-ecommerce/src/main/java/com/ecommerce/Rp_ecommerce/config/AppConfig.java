package com.ecommerce.Rp_ecommerce.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    /*
    We are using this class to create bean of ModelMapper object
     */
    @Bean
    public ModelMapper getModel() {

        return new ModelMapper();
    }
}
