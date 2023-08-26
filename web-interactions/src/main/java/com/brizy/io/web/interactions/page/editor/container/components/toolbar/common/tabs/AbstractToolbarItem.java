package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs;

import com.brizy.io.web.interactions.element.Button;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AbstractToolbarItem implements IsToolbarItem {

    Supplier<Button> tabOpener;
    Supplier<Locator> tabsLocator;

    public AbstractToolbarItem(String tabOpenerLocator, String tabsLocator, Frame frame) {
        this.tabOpener = () -> new com.brizy.io.web.interactions.element.Button(frame.locator(tabOpenerLocator));
        this.tabsLocator = () -> frame.locator(tabsLocator);
    }

    @Override
    public List<String> getTabs() {
        open();
        return tabsLocator.get().all().stream()
                .map(Locator::textContent)
                .toList();
    }

    /**
     * Will be used to open item from the toolbar to interact with tabs
     */
    @Override
    public void open() {
        tabOpener.get().click();
    }

}
