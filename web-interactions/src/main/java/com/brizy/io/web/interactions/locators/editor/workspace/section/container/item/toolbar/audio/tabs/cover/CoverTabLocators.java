package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.cover;

import com.brizy.io.web.interactions.locators.AbstractProperty;
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
public class CoverTabLocators extends AbstractProperty {

    String configurations;
    @NestedConfigurationProperty
    FileUploaderLocators cover;
    @NestedConfigurationProperty
    InputWithUnitsLocators zoom;
}