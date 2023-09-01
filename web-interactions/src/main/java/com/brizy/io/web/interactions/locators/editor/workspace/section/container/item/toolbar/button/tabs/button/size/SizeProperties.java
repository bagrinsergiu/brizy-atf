package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.tabs.button.size;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.tabs.button.size.custom.CustomProperties;
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
public class SizeProperties extends AbstractProperty {

    String items;
    @NestedConfigurationProperty
    CustomProperties custom;

}
