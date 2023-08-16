package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common;

import com.microsoft.playwright.Locator;

import java.util.List;
import java.util.function.Supplier;

public interface IsTabbedPopup {

    Supplier<Locator> getTabsLocator();

    default List<String> getTabs() {
        return getTabsLocator().get().all().stream()
                .map(Locator::textContent)
                .toList();
    }

    IsTab openTab(String tab);

}
