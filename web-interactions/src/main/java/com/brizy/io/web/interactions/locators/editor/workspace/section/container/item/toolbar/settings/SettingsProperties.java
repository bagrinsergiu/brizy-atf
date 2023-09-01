package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.ScrollBarLocators;
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
public class SettingsProperties extends AbstractProperty {

    @NestedConfigurationProperty
    Dimension width;
    @NestedConfigurationProperty
    Dimension height;
    @NestedConfigurationProperty
    ScrollBarLocators scrollBar;

}
