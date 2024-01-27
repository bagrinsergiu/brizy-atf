package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.gallery.tabs.gallery;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.InputWithUnitsLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.tabs.image.FileUploaderLocators;
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
public class GalleryTabLocators extends AbstractLocator {

    String configurations;
    @NestedConfigurationProperty
    FileUploaderLocators images;
    String layout;
    @NestedConfigurationProperty
    InputWithUnitsLocators height;
    String aspectRatio;
    String enableTags;
    String openInLightBox;

}
