package com.brizy.io.web.test.hook;

import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.service.PlaywrightService;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class PlaywrightHooks {

    PlaywrightService playwrightService;
    Storage storage;

    @Before(order = -90)
    public void initPlaywright() {
        Playwright playwright = playwrightService.create();
        storage.addValue(StorageKey.PLAYWRIGHT, playwright);
    }

    @After(order = 60)
    public void closePlaywright() {
        Playwright playwright = storage.getValue(StorageKey.PLAYWRIGHT, Playwright.class);
        playwright.close();
    }

}
