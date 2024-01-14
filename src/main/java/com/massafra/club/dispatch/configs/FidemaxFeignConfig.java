package com.massafra.club.dispatch.configs;

import com.massafra.club.dispatch.exceptions.IntegrationErrorDecoder;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FidemaxFeignConfig {
    @Value("${fidemax.token}")
    private String fidemaxToken;


    @Bean
    public Decoder feignDecoder() {

        ObjectFactory<HttpMessageConverters> messageConverters = HttpMessageConverters::new;
        return new SpringDecoder(messageConverters);
    }

    @Bean
    public RequestInterceptor bearerAuthRequestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("AuthToken", fidemaxToken);
        };
    }

    @Bean
    public IntegrationErrorDecoder errorDecoder() {
        return new IntegrationErrorDecoder();
    }

}