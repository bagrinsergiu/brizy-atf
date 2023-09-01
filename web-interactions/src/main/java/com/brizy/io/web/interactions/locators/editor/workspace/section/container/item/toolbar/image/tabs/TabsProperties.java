package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.tabs;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.tabs.image.ImageProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.tabs.mask.MaskProperties;
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
    ImageProperties image;
    @NestedConfigurationProperty
    MaskProperties mask;

}
