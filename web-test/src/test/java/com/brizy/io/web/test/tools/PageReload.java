package com.brizy.io.web.test.tools;

import com.microsoft.playwright.Page;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PageReload {

    public Page reloadAndGetPage(Page page) {
        page.reload();
        page.waitForLoadState();
        return page;
    }

}
