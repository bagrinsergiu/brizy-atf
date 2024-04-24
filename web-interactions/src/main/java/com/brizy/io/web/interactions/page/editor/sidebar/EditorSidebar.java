package com.brizy.io.web.interactions.page.editor.sidebar;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.EditorSidebarLocators;
import com.brizy.io.web.interactions.page.editor.sidebar.cms.EditorSidebarCmsPopup;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorSidebar {

    Supplier<Button> addItems;
    Supplier<Button> openCMS;
    EditorSidebarContent content;
    EditorSidebarCmsPopup editorSidebarCmsPopup;

    public EditorSidebar(EditorSidebarLocators sidebarProperties, Page page) {
        this.openCMS = () -> new Button(page.locator(sidebarProperties.getCmsPopup().getSelf()));
        this.addItems = () -> new Button(page.locator(sidebarProperties.getAddItems().getSelf()));
        this.content = new EditorSidebarContent(sidebarProperties.getAddItems().getContent().getMain(), page);
        this.editorSidebarCmsPopup = new EditorSidebarCmsPopup(sidebarProperties.getCmsPopup(), page);
    }

    public EditorSidebarContent fromAddElementsControl() {
        addItems.get().click();
        return content;
    }

    public EditorSidebarCmsPopup openCms() {
        openCMS.get().click();
        return editorSidebarCmsPopup;
    }

}
