package com.brizy.io.web.interactions.page;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public abstract class AbstractPage {

    Page page;

    public byte[] takeScreenshot() {
        return page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
    }

    public void waitForDomToBeLoaded() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

}
