package com.brizy.io.web.interactions.page.editor.container.components.toolbar;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class Toolbar<T extends Property> {

    Supplier<Button> delete;
    Supplier<Button> duplicate;
    Supplier<Locator> toolbarItems;

    protected Toolbar(ToolbarLocators toolbarProperties, Frame page) {
        this.toolbarItems = () -> page.locator(toolbarProperties.getItem());
        this.delete = () -> new Button(page.locator(toolbarProperties.getDelete()));
        this.duplicate = () -> new Button(page.locator(toolbarProperties.getDuplicate()));
    }

    public abstract T getProperties();

    public abstract void setProperties(T properties);

    /**
     * Opens a specific toolbar item popup
     *
     * @param toolbarItemTitle - the title of the item to open
     * @return object of type IsToolbarItem
     */
    public abstract IsToolbarItem openTabbedPopup(String toolbarItemTitle);

    public void delete() {
        delete.get().click();
    }

    public void duplicate() {
        duplicate.get().click();
    }

    /**
     * Method to get toolbar items displayed in editor
     *
     * @return a list of strings
     */
    public List<String> getItems() {
        return toolbarItems.get().all().stream()
                .map(locator -> locator.getAttribute("title"))
                .toList();
    }

}