package com.brizy.io.web.property.converter;

import com.brizy.io.web.exception.IllegalPropertyValueException;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@ConfigurationPropertiesBinding
public class PathConverter implements Converter<String, Path> {

    @Override
    public Path convert(String source) {
        if (source.isEmpty() || source.isBlank()) {
            throw new IllegalPropertyValueException("Empty value provided to property!");
        }
        return Paths.get(source);
    }

}
