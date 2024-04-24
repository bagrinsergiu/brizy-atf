package com.brizy.io.web.interactions.page.publish.common;

import com.brizy.io.web.interactions.page.common.GenericComponent;
import com.microsoft.playwright.Locator;
import org.apache.commons.lang3.StringUtils;

public class PublishedComponent extends GenericComponent {

    public PublishedComponent(Locator componentLocator) {
        super(componentLocator);
    }

    public String getName() {
        return StringUtils.EMPTY;
    }

}
