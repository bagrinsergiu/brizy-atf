package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.icon.tabs.icon.icon.tabs;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.icon.tabs.icon.icon.tabs.background.BackgroundLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.icon.tabs.icon.icon.tabs.icon.IconLocators;
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
public class IconTabsLocators extends AbstractProperty {

    @NestedConfigurationProperty
    BackgroundLocators background;
    @NestedConfigurationProperty
    IconLocators icon;

}
