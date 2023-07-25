package com.brizy.io.web.interactions.page.editor.container.components.toolbar.counter.tab.types;

import com.brizy.io.web.interactions.page.editor.container.components.toolbar.counter.GenericCounter;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.counter.tab.AdvancedTab;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.counter.CounterProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.counter.tabs.TabsProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AdvancedCounter extends GenericCounter {

    Supplier<Button> advancedButton;
    Supplier<AdvancedTab> advancedSubMenu;

    public AdvancedCounter(CounterProperties counterProperties, Frame page) {
        super(counterProperties, page);
        TabsProperties tabs = counterProperties.getTabs();
        advancedButton = () -> new Button(page.locator(tabs.getAdvanced().getSelf()));
        advancedSubMenu = () -> new AdvancedTab(tabs.getAdvanced(), page);
    }

    public AdvancedTab advanced() {
        advancedButton.get().click();
        return advancedSubMenu.get();
    }

}
