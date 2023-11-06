package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.video.tabs.player;

import com.brizy.io.web.interactions.locators.AbstractProperty;
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
public class PlayerTabLocators extends AbstractProperty {

    @NestedConfigurationProperty
    FileUploaderLocators coverImage;
    String controls;
    String branding;
    String lazyLoad;
    String privacyMode;
    String configurations;

}
