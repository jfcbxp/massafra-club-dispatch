package com.massafra.club.dispatch.configs;


import com.massafra.club.dispatch.converters.FidemaxCustomerConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Autowired
    private FidemaxCustomerConverter fidemaxCustomerConverter;

    @Bean
    public ModelMapper modelMapper() {

        final var modelMapper = new ModelMapper();

        modelMapper.addConverter(fidemaxCustomerConverter);

        return modelMapper;
    }
}
