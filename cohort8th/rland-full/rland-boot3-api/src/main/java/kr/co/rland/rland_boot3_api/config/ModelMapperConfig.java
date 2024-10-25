package kr.co.rland.rland_boot3_api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    // ModelMapper modelMapper = new ModelMapper();

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
