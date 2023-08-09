package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.map.MapProperties;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.colors.Colors;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.settings.Settings;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.ToolbarProperties;
import com.microsoft.playwright.Frame;

import java.util.Objects;
import java.util.function.Supplier;

public class MapToolbar extends ComponentToolbar<MapProperties> {

    Supplier<Colors> colorsMenu;
    Supplier<Settings> settingsMenu;

    public MapToolbar(ToolbarProperties properties, Frame page) {
        super(properties, page);
        this.colorsMenu = () -> new Colors(properties.getColors(), page);
        this.settingsMenu = () -> new Settings(properties.getSettings(), page);
    }

    @Override
    public void setProperties(MapProperties properties) {
        if (Objects.nonNull(properties.getColors())) {
            openColors();
            colorsMenu.get().border().with(properties.getColors());
        }
        if (Objects.nonNull(properties.getSettings())) {
            openSettings();
            settingsMenu.get().with(properties.getSettings());
        }
    }

    @Override
    public EditorComponentProperty getProperties() {
        return null;
    }
}