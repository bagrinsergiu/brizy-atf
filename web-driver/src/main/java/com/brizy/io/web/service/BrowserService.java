package com.brizy.io.web.service;

import com.brizy.io.web.enums.BrowserType;
import com.brizy.io.web.property.WebDriverProperties;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Playwright;
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
class BrowserService {

    @Getter(value = PUBLIC, onMethod = @__({@Bean}))
    Browser browser;

    @Autowired
    protected BrowserService(ModelMapper modelMapper, Playwright playwright, WebDriverProperties props) {
        LaunchOptions launchOptions = modelMapper.map(props.getBrowser(), LaunchOptions.class);
        BrowserType browserType = props.getBrowser().getType();
        this.browser = browserType.getBrowserType(playwright).launch(launchOptions);
    }

    protected void cleanUp() {
        if (Objects.nonNull(browser)) {
            browser.close();
        }
    }

}
