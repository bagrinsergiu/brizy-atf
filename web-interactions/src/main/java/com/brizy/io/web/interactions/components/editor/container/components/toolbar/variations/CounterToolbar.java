package com.brizy.io.web.interactions.components.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.counter.CounterProperties;
import com.brizy.io.web.interactions.components.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.components.editor.container.components.toolbar.counter.tab.types.CountersFactory;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.ToolbarProperties;
import com.microsoft.playwright.Frame;

import java.util.function.Supplier;

public class CounterToolbar extends ComponentToolbar {

    ToolbarProperties properties;
    Frame page;
    Supplier<Button> counterButton;

    public CounterToolbar(ToolbarProperties properties, Frame page) {
        super(properties, page);
        this.counterButton = () -> new Button(page.locator(properties.getCounter().getSelf()));
        this.page = page;
        this.properties = properties;
    }

    @Override
    public void withProperties(Property properties) {
        counterButton.get().click();
        CountersFactory.of(this.properties.getCounter(), page).getCounter().change(((CounterProperties) properties).getCounter());
    }

    @Override
    public EditorComponentProperty getProperties() {
        counterButton.get().click();
        return CountersFactory.of(properties.getCounter(), page).getCounter().getProperties();
    }

}