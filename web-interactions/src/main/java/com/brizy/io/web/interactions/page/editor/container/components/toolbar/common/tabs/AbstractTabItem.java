package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs;

import com.brizy.io.web.interactions.element.Button;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public abstract class AbstractTabItem implements IsPopUpTab {

    Supplier<Locator> configurations;
    Supplier<Button> tabButton;
    Supplier<Boolean> isDisplayed;

    public AbstractTabItem(String configurationsLocator, String tabButtonLocator, Frame frame) {
        this.configurations = () -> frame.locator(configurationsLocator);
        this.tabButton = () -> new Button(frame.locator(tabButtonLocator));
        this.isDisplayed = () -> frame.isVisible(tabButtonLocator);
    }

    protected List<String> getWebConfigurationsWithoutOpening() {
        return configurations.get().all().stream()
                .map(Locator::textContent)
                .toList();
    }

    @Override
    public List<String> getWebConfigurations() {
        open();
        return getWebConfigurationsWithoutOpening();
    }

    @Override
    public void open() {
        tabButton.get().click();
    }

    public boolean isDisplayed() {
        return isDisplayed.get();
    }

}
