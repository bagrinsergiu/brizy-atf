package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.line.tabs;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.line.tabs.icon.IconTabLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.line.tabs.line.LineTabLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.line.tabs.text.TextTabLocators;
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
public class LineTabsLocators extends AbstractLocator {

    @NestedConfigurationProperty
    IconTabLocators icon;
    @NestedConfigurationProperty
    LineTabLocators line;
    @NestedConfigurationProperty
    TextTabLocators text;

}
