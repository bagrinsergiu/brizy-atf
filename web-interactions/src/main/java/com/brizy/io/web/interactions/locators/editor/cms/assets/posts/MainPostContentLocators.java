package com.brizy.io.web.interactions.locators.editor.cms.assets.posts;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.DropDownLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.tabs.image.FileUploaderLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class MainPostContentLocators extends AbstractLocator {

    String title;
    String slug;
    String excerpt;
    @NestedConfigurationProperty
    FileUploaderLocators featuredImage;
    @NestedConfigurationProperty
    DropDownLocators published;

}
