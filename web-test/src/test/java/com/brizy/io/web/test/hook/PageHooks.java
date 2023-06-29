package com.brizy.io.web.test.hook;

import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.service.PageService;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class PageHooks {

    PageService pageService;
    Storage storage;

    @Before(order = -60)
    public void doPageInit() {
        BrowserContext context = storage.getValue(StorageKey.CONTEXT, BrowserContext.class);
        Page page = pageService.create(context);
        page.navigate(EMPTY);
        storage.addValue(StorageKey.INIT_PAGE, page);
    }

    @After(order = 90)
    public void doClosePage() {
        Page page = storage.getValue(StorageKey.INIT_PAGE, Page.class);
        page.close();
    }

}
