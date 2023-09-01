package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.tabs.button;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.tabs.button.corner.CornerProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.tabs.button.size.SizeProperties;
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
public class ButtonProperties extends AbstractProperty {

    @NestedConfigurationProperty
    SizeProperties size;
    String fill;
    @NestedConfigurationProperty
    CornerProperties corner;

}
