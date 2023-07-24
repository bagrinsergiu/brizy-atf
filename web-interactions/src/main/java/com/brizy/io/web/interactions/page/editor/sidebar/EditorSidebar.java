package com.brizy.io.web.interactions.page.editor.sidebar;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.properties.editor.EditorSidebarProperties;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorSidebar {

    Supplier<Button> addItems;
    EditorSidebarContent content;

    public EditorSidebar(EditorSidebarProperties sidebarProperties, Page page) {
        this.addItems = () -> new Button(page.locator(sidebarProperties.getAddItems().getSelf()));
        this.content = new EditorSidebarContent(sidebarProperties.getAddItems().getContent().getMain(), page);
    }

    public EditorSidebarContent fromAddElementsControl() {
        addItems.get().click();
        return content;
    }

}
