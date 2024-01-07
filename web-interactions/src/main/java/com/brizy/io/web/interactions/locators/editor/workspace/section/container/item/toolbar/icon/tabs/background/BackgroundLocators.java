package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.icon.tabs.background;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.tabs.button.corner.CornerLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.InputWithUnitsLocators;
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
public class BackgroundLocators extends AbstractLocator {

    String configurations;
    @NestedConfigurationProperty
    InputWithUnitsLocators size;
    String fill;
    @NestedConfigurationProperty
    CornerLocators corner;

}
