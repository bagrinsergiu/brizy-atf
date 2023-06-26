package com.brizy.io.web.test.tools;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PageSwitcher {

    private List<Page> getPageFromContext(Page page) {
        return page.context().pages();
    }

    private void updateTheContext(Page page) {
        List<Page> pages = getPageFromContext(page);
        pages.get(0).bringToFront();
        pages.get(0).reload();
        pages.get(0).waitForLoadState();
    }

    public Page switchFromCurrentPageToSpecificTab(Page page, int tabNumber) {
        updateTheContext(page);
        Page pageToSearchFor = getPageFromContext(page).get(tabNumber);
        pageToSearchFor.bringToFront();
        pageToSearchFor.waitForLoadState();
        return pageToSearchFor;
    }

}
