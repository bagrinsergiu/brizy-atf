package com.brizy.io.web.interactions.components.editor.container.components.toolbar;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.interactions.components.editor.container.components.toolbar.colors.Colors;
import com.brizy.io.web.interactions.components.editor.container.components.toolbar.settings.Settings;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.ToolbarProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class ComponentToolbar {

    Supplier<Button> colorsButton;
    Supplier<Colors> colorsMenu;
    Supplier<Button> settingsButton;
    Supplier<Settings> settingsMenu;

    protected ComponentToolbar(ToolbarProperties toolbarProperties, Frame page) {
        this.colorsButton = () -> new Button(page.locator(toolbarProperties.getColors().getSelf()));
        this.colorsMenu = () -> new Colors(toolbarProperties.getColors(), page);
        this.settingsButton = () -> new Button(page.locator(toolbarProperties.getSettings().getSelf()));
        this.settingsMenu = () -> new Settings(toolbarProperties.getSettings(), page);
    }

    protected Colors colors() {
        colorsButton.get().click();
        return colorsMenu.get();
    }

    protected Settings settings() {
        settingsButton.get().click();
        return settingsMenu.get();
    }

    public void withProperties(Property properties) {
        if(Objects.nonNull(properties.getColors())) {
            colors().border().with(properties.getColors());
        }
        if (Objects.nonNull(properties.getSettings())) {
            settings().with(properties.getSettings());
        }
    }

    public abstract EditorComponentProperty getProperties();

}