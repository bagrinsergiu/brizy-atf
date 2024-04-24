package com.brizy.io.web.interactions.page.publish.section.items;

import com.brizy.io.web.interactions.page.publish.common.PublishedComponent;
import com.microsoft.playwright.Locator;

public class Gallery extends PublishedComponent {

    public Gallery(Locator componentLocator) {
        super(componentLocator);
    }

    @Override
    public String getName() {
        return "gallery";
    }

}
