package com.brizy.io.web.common.mapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Configuration
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ModelMapperConfiguration {

    @Getter(onMethod = @__(@Bean))
    ModelMapper modelMapper;

    public ModelMapperConfiguration() {
        var mapper = new ModelMapper();
        var configuration = mapper.getConfiguration();
        configuration.setFieldAccessLevel(PRIVATE);
        configuration.setMethodAccessLevel(PRIVATE);
        configuration.setFieldMatchingEnabled(true);
        configuration.setAmbiguityIgnored(true);
        configuration.setSkipNullEnabled(true);
        this.modelMapper = mapper;
    }

}