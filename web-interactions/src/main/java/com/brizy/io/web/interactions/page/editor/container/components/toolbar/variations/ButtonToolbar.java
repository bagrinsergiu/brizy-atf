package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.button.ButtonProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.ToolbarProperties;
import com.microsoft.playwright.Frame;

public class ButtonToolbar extends ComponentToolbar<ButtonProperties> {

    public ButtonToolbar(ToolbarProperties properties, Frame page) {
        super(properties, page);
    }

    @Override
    public void setProperties(ButtonProperties properties) {
//        TODO to be implemente
    }

    @Override
    public EditorComponentProperty getProperties() {
        return null;
    }
}