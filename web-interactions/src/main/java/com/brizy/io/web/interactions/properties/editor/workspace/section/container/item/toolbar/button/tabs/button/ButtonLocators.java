package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.button;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.button.corner.CornerLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.button.size.SizeProperties;
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
public class ButtonLocators extends AbstractProperty {

    String configurations;
    @NestedConfigurationProperty
    SizeProperties size;
    String fill;
    @NestedConfigurationProperty
    CornerLocators corner;

}
