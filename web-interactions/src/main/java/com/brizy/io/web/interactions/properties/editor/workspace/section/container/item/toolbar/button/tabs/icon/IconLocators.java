package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.icon;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.icon.icon.IconPickerLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.icon.size.SizeLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.icon.spacing.SpacingLocators;
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
public class IconLocators extends AbstractProperty {

    String configurations;
    @NestedConfigurationProperty
    IconPickerLocators icon;
    String position;
    @NestedConfigurationProperty
    SizeLocators size;
    @NestedConfigurationProperty
    SpacingLocators spacing;

}