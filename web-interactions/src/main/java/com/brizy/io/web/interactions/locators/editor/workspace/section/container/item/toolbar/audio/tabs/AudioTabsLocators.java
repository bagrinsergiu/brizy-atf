package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.advanced.AdvancedTabLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.appearance.AppearanceTabLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.audio.AudioTabLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.buttons.ButtonsTabLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.audio.tabs.cover.CoverTabLocators;
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
public class AudioTabsLocators extends AbstractLocator {

    @NestedConfigurationProperty
    AudioTabLocators audio;
    @NestedConfigurationProperty
    ButtonsTabLocators buttons;
    @NestedConfigurationProperty
    CoverTabLocators cover;
    @NestedConfigurationProperty
    AdvancedTabLocators advanced;
    @NestedConfigurationProperty
    AppearanceTabLocators appearance;

}
