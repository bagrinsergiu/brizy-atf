package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.SettingsLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.tabs.SettingsTabsLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
abstract class AbstractSettingsPopUp extends AbstractTabItem {

    SettingsLocators settingsLocators;

    public AbstractSettingsPopUp(SettingsLocators settingsLocators, Frame frame) {
        super(settingsLocators.getTabs().getConfigurations(), settingsLocators.getSelf(), frame);
        this.settingsLocators = settingsLocators;
    }

    protected SettingsTabsLocators getTabsLocators() {
        return settingsLocators.getTabs();
    }

}
