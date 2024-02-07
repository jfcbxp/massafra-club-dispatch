package com.massafra.club.dispatch.configs;


import com.massafra.club.dispatch.converters.FidemaxCustomerConverter;
import com.massafra.club.dispatch.converters.FidemaxOrderConverter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ModelMapperConfig {
    private final FidemaxCustomerConverter fidemaxCustomerConverter;
    private final FidemaxOrderConverter fidemaxOrderConverter;

    @Bean
    public ModelMapper modelMapper() {

        final var modelMapper = new ModelMapper();

        modelMapper.addConverter(fidemaxCustomerConverter);
        modelMapper.addConverter(fidemaxOrderConverter);

        return modelMapper;
    }
}
