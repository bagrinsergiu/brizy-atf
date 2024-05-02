package com.brizy.io.web.test.service;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.cucumber.spring.ScenarioScope;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
@ScenarioScope
public class PageService {

    public Page create(BrowserContext browserContext) {
        Page page = browserContext.newPage();
        page.setDefaultTimeout(10000);
        return page;
    }

}
