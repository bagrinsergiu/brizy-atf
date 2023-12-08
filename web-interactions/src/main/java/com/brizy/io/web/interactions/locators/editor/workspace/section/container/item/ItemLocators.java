package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.content.ItemContentLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.right_click_context.RightClickContextProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.type.ItemTypeLocators;
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
public class ItemLocators extends AbstractProperty {

    @NestedConfigurationProperty
    ToolbarLocators toolbar;
    @NestedConfigurationProperty
    RightClickContextProperties rightClickContext;
    @NestedConfigurationProperty
    ItemTypeLocators type;
    @NestedConfigurationProperty
    ItemContentLocators content;
    String borderButton;

}
