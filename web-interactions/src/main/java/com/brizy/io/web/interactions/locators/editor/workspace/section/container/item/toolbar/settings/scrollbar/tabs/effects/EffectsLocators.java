package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.effects;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.effects.entrance.EntranceLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.effects.hover.HoverLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.effects.scroll.ScrollLocators;
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
public class EffectsLocators extends AbstractLocator {

    String tabContent;
    String tabs;
    @NestedConfigurationProperty
    EntranceLocators entrance;
    @NestedConfigurationProperty
    HoverLocators hover;
    @NestedConfigurationProperty
    ScrollLocators scroll;

}
