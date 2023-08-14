package com.brizy.io.web.test.service;

import com.brizy.io.web.service.WebDriverService;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import io.cucumber.spring.ScenarioScope;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
@ScenarioScope
public class BrowserService {

    WebDriverService webDriverService;

    public Browser create(Playwright playwright) {
        return webDriverService.createBrowser(playwright);
    }

}
