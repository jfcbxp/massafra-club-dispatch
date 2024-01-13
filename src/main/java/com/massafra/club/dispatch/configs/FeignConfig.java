package com.massafra.club.dispatch.configs;

import com.massafra.club.dispatch.exceptions.IntegrationErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public IntegrationErrorDecoder errorDecoder() {
        return new IntegrationErrorDecoder();
    }


}