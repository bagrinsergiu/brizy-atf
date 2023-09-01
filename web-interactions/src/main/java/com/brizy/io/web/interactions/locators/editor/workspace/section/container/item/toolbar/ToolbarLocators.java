package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.ButtonLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.colors.ColorsLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.counter.CounterLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.ImageLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.link.LinkLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.SettingsProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.typography.TypographyProperties;
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
public class ToolbarLocators {

    String item;
    String align;
    @NestedConfigurationProperty
    TypographyProperties typography;
    @NestedConfigurationProperty
    ColorsLocators colors;
    @NestedConfigurationProperty
    CounterLocators counter;
    @NestedConfigurationProperty
    ButtonLocators button;
    @NestedConfigurationProperty
    SettingsProperties settings;
    @NestedConfigurationProperty
    ImageLocators image;
    @NestedConfigurationProperty
    LinkLocators link;

}