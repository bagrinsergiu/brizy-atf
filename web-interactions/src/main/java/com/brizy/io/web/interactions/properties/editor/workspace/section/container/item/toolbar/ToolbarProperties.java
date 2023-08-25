package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar;

import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.ButtonLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.ColorsProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.counter.CounterProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.ImageProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.LinkLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.SettingsProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.typography.TypographyProperties;
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
public class ToolbarProperties {

    String item;
    String align;
    @NestedConfigurationProperty
    TypographyProperties typography;
    @NestedConfigurationProperty
    ColorsProperties colors;
    @NestedConfigurationProperty
    CounterProperties counter;
    @NestedConfigurationProperty
    ButtonLocators button;
    @NestedConfigurationProperty
    SettingsProperties settings;
    @NestedConfigurationProperty
    ImageProperties image;
    @NestedConfigurationProperty
    LinkLocators link;

}
