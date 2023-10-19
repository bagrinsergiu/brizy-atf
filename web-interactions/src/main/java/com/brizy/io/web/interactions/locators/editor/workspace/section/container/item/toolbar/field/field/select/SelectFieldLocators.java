package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.select;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.select.item.SelectItemLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.select.new_item.SelectNewItemLocators;
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
public class SelectFieldLocators {

    @NestedConfigurationProperty
    SelectItemLocators item;
    @NestedConfigurationProperty
    SelectNewItemLocators newItem;


}
