package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.microsoft.playwright.Locator;

public class EmptyContainer extends Component<Property> {

    public EmptyContainer(Locator locator) {
        super(locator);
    }

    @Override
    public Property getEditorProperties() {
//        Intentionally left null, no properties for now
        return null;
    }

    @Override
    protected ComponentToolbar<Property> getToolbar() {
//        Intentionally left null, shouldn't get it
        return null;
    }
}

