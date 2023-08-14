package com.brizy.io.web.service;

import com.brizy.io.web.property.WebDriverProperties;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Playwright.CreateOptions;
import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

import static lombok.AccessLevel.*;

@Configuration
@FieldDefaults(level = PRIVATE, makeFinal = true)
class PlaywrightService {

    @Getter(value = PUBLIC, onMethod = @__({@Bean}))
    Playwright playwright;

    @Autowired
    protected PlaywrightService(ModelMapper modelMapper, WebDriverProperties props) {
        this.playwright = Playwright.create(modelMapper.map(props.getPlaywright(), CreateOptions.class));
    }

    @PreDestroy
    public void cleanUp() {
        if (Objects.nonNull(playwright)) {
            playwright.close();
        }
    }

}
