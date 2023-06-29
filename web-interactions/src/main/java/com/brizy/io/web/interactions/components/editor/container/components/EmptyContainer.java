package com.brizy.io.web.interactions.components.editor.container.components;

import com.brizy.io.web.interactions.components.editor.container.components.toolbar.ComponentToolbar;
import com.microsoft.playwright.Locator;

public class EmptyContainer extends Component {

    public EmptyContainer(Locator locator) {
        super(locator);
    }

    @Override
    protected ComponentToolbar getToolbar() {
        return null;
    }
}
