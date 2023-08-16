package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.button.ButtonLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.icon.IconProperties;
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
public class TabsProperties extends AbstractProperty {

    @NestedConfigurationProperty
    ButtonLocators button;
    @NestedConfigurationProperty
    IconProperties icon;

}
