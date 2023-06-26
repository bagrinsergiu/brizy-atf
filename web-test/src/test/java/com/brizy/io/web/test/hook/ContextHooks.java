package com.brizy.io.web.test.hook;

import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.service.ContextService;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class ContextHooks {

    ContextService contextService;
    Storage storage;

    @Before(order = -70)
    public void initContext() {
        Browser browser = storage.getValue(StorageKey.BROWSER, Browser.class);
        BrowserContext context = contextService.create(browser);
        storage.addValue(StorageKey.CONTEXT, context);
    }

    @After(order = 80)
    public void closeContext() {
        BrowserContext context = storage.getValue(StorageKey.CONTEXT, BrowserContext.class);
        context.close();
    }

}
