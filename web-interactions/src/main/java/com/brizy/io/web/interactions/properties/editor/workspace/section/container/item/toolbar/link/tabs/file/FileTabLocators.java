package com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.file;

import com.brizy.io.web.interactions.properties.AbstractProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.tabs.image.FileUploaderLocators;
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
public class FileTabLocators extends AbstractProperty {

    String configurations;
    @NestedConfigurationProperty
    FileUploaderLocators file;

}