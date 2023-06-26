package com.brizy.io.web.service;


import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE)
class PageService {

    Page page;

    protected Page createNewPage(BrowserContext context) {
        return context.newPage();
    }

    protected void reload() {
        page.reload();
    }

    protected void close() {
        page.close();
    }

}