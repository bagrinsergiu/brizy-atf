package com.brizy.io.web.interactions.page.editor.sidebar;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.EditorSidebarLocators;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorSidebar {

    Supplier<Button> addItems;
    Supplier<Button> openCms;
    EditorSidebarContent content;

    public EditorSidebar(EditorSidebarLocators sidebarProperties, Page page) {
        this.openCms = () -> new Button(page.locator(sidebarProperties.getCms()));
        this.addItems = () -> new Button(page.locator(sidebarProperties.getAddItems().getSelf()));
        this.content = new EditorSidebarContent(sidebarProperties.getAddItems().getContent().getMain(), page);
    }

    public EditorSidebarContent fromAddElementsControl() {
        addItems.get().click();
        return content;
    }

    public void openCms() {
        openCms.get().click();
    }

}
