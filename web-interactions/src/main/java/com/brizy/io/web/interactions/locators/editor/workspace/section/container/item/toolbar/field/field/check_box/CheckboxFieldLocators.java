package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.check_box;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.check_box.item.CheckBoxItemLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.check_box.new_item.CheckBoxNewItemLocators;
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
public class CheckboxFieldLocators {

    @NestedConfigurationProperty
    CheckBoxItemLocators item;
    @NestedConfigurationProperty
    CheckBoxNewItemLocators newItem;


}
