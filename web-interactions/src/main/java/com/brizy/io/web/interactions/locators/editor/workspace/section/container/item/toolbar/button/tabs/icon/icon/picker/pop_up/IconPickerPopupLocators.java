package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.tabs.icon.icon.picker.pop_up;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.DropDownLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.GridLocators;
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
public class IconPickerPopupLocators extends AbstractLocator {

    String tabs;
    @NestedConfigurationProperty
    DropDownLocators categories;
    String search;
    @NestedConfigurationProperty
    GridLocators grid;
    String closeButton;

}
