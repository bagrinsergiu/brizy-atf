package com.brizy.io.web.test.service;

import com.brizy.io.web.service.WebDriverService;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
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
public class ContextService {

    WebDriverService webDriverService;

    @PreDestroy
    public void close() {
        webDriverService.closeContext();
    }

    public BrowserContext create(Browser browser) {
        return webDriverService.createContext(browser);
    }

}
