package com.brizy.io.web.interactions.components.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.interactions.components.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.ToolbarProperties;
import com.microsoft.playwright.Frame;

import java.util.Objects;

public class ButtonToolbar extends ComponentToolbar {

    public ButtonToolbar(ToolbarProperties properties, Frame page) {
        super(properties, page);
    }

    @Override
    public void withProperties(Property properties) {
        super.withProperties(properties);
    }

    @Override
    public EditorComponentProperty getProperties() {
        return null;
    }
}