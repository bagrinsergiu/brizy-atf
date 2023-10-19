package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.advanced.AdvancedLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.background.BackgroundLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.FieldLocator;
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
public class FieldTabsLocators {

    @NestedConfigurationProperty
    BackgroundLocator background;
    @NestedConfigurationProperty
    FieldLocator field;
    @NestedConfigurationProperty
    AdvancedLocator advanced;

}
