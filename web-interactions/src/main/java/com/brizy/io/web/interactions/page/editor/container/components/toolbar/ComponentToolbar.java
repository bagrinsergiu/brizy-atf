package com.brizy.io.web.interactions.page.editor.container.components.toolbar;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTabbedPopup;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.ToolbarProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class ComponentToolbar<T extends Property> {

    Supplier<Locator> toolbarItems;

    protected ComponentToolbar(ToolbarProperties toolbarProperties, Frame page) {
        this.toolbarItems = () -> page.locator(toolbarProperties.getItem());
    }

    public List<String> getItems() {
        return toolbarItems.get().all().stream()
                .map(locator -> locator.getAttribute("title"))
                .toList();
    }

    public abstract void setProperties(T properties);

    public abstract EditorComponentProperty getProperties();

    //    TODO refactor to abstract
    public IsTabbedPopup openTabbedPopup(String toolbarItemTitle) {
        return null;
    }

}