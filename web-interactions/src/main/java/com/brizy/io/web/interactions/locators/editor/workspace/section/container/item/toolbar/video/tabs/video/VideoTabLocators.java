package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs.video;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.InputWithPopulationLocators;
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
public class VideoTabLocators extends AbstractLocator {

    @NestedConfigurationProperty
    InputWithPopulationLocators link;
    String type;
    String url;
    String ratio;
    String configurations;
    @NestedConfigurationProperty
    FileUploaderLocators file;

}
