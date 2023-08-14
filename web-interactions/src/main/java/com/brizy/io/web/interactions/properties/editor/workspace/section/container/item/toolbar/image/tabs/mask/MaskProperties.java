package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.tabs.mask;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.tabs.image.ImageUploaderProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.tabs.mask.size.SizeProperties;
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
public class MaskProperties extends AbstractProperty {

    String configurations;
    String shape;
    @NestedConfigurationProperty
    SizeProperties size;
    String position;
    String repeat;
    ImageUploaderProperties image;

}
