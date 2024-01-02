package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthHeightEffectsAndStylingProperties;
import com.brizy.io.web.common.dto.element.properties.map.MapProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.Toolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsPopUp;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.pop_up.SettingsWithWidthHeightEffectsAndStyling;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.colors.Colors;
import com.microsoft.playwright.Frame;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Objects;
import java.util.function.Supplier;

public class MapToolbar extends Toolbar<MapProperties> {

    Supplier<Colors> colorsMenu;
    Supplier<SettingsPopUp<SettingsWithWidthHeightEffectsAndStylingProperties>> settings;

    public MapToolbar(ToolbarLocators properties, Frame page) {
        super(properties, page);
        this.colorsMenu = () -> new Colors(properties.getColors(), page);
        this.settings = () -> new SettingsWithWidthHeightEffectsAndStyling(properties.getSettings(), page);
    }

    @Override
    public void setProperties(MapProperties properties) {
        if (Objects.nonNull(properties.getColors())) {
            colorsMenu.get().border().with(properties.getColors());
        }
        if (Objects.nonNull(properties.getSettings())) {
            settings.get().setProperties(properties.getSettings());
        }
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        throw new NotImplementedException();
    }

    @Override
    public MapProperties getProperties() {
        return null;
    }
}