package com.brizy.io.web.interactions.page.editor.container.components.toolbar;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.HasTabs;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.ToolbarProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class ComponentToolbar<T extends Property> {

    Supplier<Button> colorsButton;
    Supplier<Button> settingsButton;
    Supplier<Locator> toolbarItems;

    protected ComponentToolbar(ToolbarProperties toolbarProperties, Frame page) {
        this.toolbarItems = () -> page.locator(toolbarProperties.getItem());
        this.colorsButton = () -> new Button(page.locator(toolbarProperties.getColors().getSelf()));
        this.settingsButton = () -> new Button(page.locator(toolbarProperties.getSettings().getSelf()));
    }

    public List<String> getItems() {
        return toolbarItems.get().all().stream()
                .map(locator -> locator.getAttribute("title"))
                .toList();
    }

    //    TODO remove and encapsulate
    protected void openColors() {
        colorsButton.get().click();
    }

    protected void openSettings() {
        settingsButton.get().click();
    }

    public abstract void setProperties(T properties);

    public abstract EditorComponentProperty getProperties();

    //    TODO refactor to abstract
    public HasTabs openTabbedPopup(String toolbarItemTitle) {
        return null;
    }

}