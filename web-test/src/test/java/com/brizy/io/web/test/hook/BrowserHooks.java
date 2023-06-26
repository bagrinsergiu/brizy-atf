package com.brizy.io.web.test.hook;

import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.service.BrowserService;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class BrowserHooks {

    BrowserService browserService;
    Storage storage;

    @Before(order = -80)
    public void initBrowser() {
        Playwright playwright = storage.getValue(StorageKey.PLAYWRIGHT, Playwright.class);
        Browser browser = browserService.create(playwright);
        storage.addValue(StorageKey.BROWSER, browser);
    }

    @After(order = 70)
    public void closeBrowser() {
        Browser browser = storage.getValue(StorageKey.BROWSER, Browser.class);
        browser.close();
    }

}
