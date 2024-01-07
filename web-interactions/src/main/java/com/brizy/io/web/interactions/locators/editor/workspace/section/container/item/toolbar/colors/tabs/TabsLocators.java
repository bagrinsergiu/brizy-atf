package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.colors.tabs;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.colors.tabs.background.BackgroundLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.colors.tabs.border.BorderLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.colors.tabs.overlay.OverlayLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.colors.tabs.shadow.ShadowLocators;
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
public class TabsLocators extends AbstractLocator {

    @NestedConfigurationProperty
    BackgroundLocators background;
    @NestedConfigurationProperty
    BorderLocators border;
    @NestedConfigurationProperty
    ShadowLocators shadow;
    @NestedConfigurationProperty
    OverlayLocators overlay;

}
