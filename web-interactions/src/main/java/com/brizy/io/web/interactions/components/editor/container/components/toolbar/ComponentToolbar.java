package com.brizy.io.web.interactions.components.editor.container.components.toolbar;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.interactions.components.editor.container.components.toolbar.colors.Colors;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.ToolbarProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class ComponentToolbar {

    Supplier<Button> colorsButton;
    Supplier<Colors> colorsMenu;

    protected ComponentToolbar(ToolbarProperties toolbarProperties, Frame page) {
        this.colorsButton = () -> new Button(page.locator(toolbarProperties.getColors().getSelf()));
        this.colorsMenu = () -> new Colors(toolbarProperties.getColors(), page);
    }

    protected Colors colors() {
        colorsButton.get().click();
        return colorsMenu.get();
    }

    public abstract void withProperties(Property properties);

    public abstract EditorComponentProperty getProperties();

}