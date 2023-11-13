package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.audio;

import com.brizy.io.web.interactions.locators.AbstractProperty;
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
public class AudioTabLocators extends AbstractProperty {

    @NestedConfigurationProperty
    InputWithPopulationLocators link;
    String audio;
    String style;
    String autoplay;
    String configurations;
    @NestedConfigurationProperty
    FileUploaderLocators file;
    String icons;
    String loop;

}
