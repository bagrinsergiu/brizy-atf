package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.ScrollBarLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.tabs.SettingsTabsLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.tabs.grid.SettingsGridLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class SettingsLocators extends AbstractLocator {

    @NestedConfigurationProperty
    ScrollBarLocators scrollBar;
    @NestedConfigurationProperty
    SettingsTabsLocators tabs;
    @NestedConfigurationProperty
    SettingsGridLocators grid;

}
