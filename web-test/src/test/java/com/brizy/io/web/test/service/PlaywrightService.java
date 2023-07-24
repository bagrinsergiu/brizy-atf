package com.brizy.io.web.test.service;

import com.brizy.io.web.service.WebDriverService;
import com.microsoft.playwright.Playwright;
import io.cucumber.spring.ScenarioScope;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
@ScenarioScope
public class PlaywrightService {

    WebDriverService webDriverService;

    public Playwright create() {
        return webDriverService.createInstance();
    }

}
