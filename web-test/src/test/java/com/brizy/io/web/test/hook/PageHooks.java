package com.brizy.io.web.test.hook;

import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.service.ActivePageService;
import com.brizy.io.web.test.service.PageService;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import io.cucumber.java.Before;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class PageHooks {

    ActivePageService activePageService;
    PageService pageService;
    Storage storage;

    @Before(order = -60)
    public void doPageInit() {
        BrowserContext context = storage.getValue(StorageKey.CONTEXT, BrowserContext.class);
        Page page = pageService.create(context);
        page.navigate(EMPTY);
        activePageService.setPage(page);
    }

}
