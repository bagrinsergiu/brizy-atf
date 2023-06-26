package com.brizy.io.web.interactions.page.editor;

import com.brizy.io.web.interactions.element.frame.EditorContainer;
import com.brizy.io.web.interactions.element.nested.EditorBottomPanel;
import com.brizy.io.web.interactions.element.nested.EditorPopUpMenu;
import com.brizy.io.web.interactions.element.nested.EditorSidebar;
import com.brizy.io.web.interactions.page.PageBuilder;
import com.brizy.io.web.interactions.properties.editor.EditorPageProperties;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPage {

    EditorPopUpMenu editorPopUpMenu;
    EditorContainer container;
    EditorBottomPanel bottomPanel;
    Page page;
    PageBuilder pageBuilder;

    public EditorPage(EditorPageProperties editorPageProperties, Page page) {
        this.bottomPanel = new EditorBottomPanel(editorPageProperties.getBottomPanel(), page);
        this.editorPopUpMenu = new EditorPopUpMenu(editorPageProperties.getEditorPopUp(), page);
        this.container = new EditorContainer(editorPageProperties.getFrame(), page);
        EditorSidebar sidebar = new EditorSidebar(editorPageProperties.getSidebar(), page);
        this.page = page;
        this.pageBuilder = new PageBuilder(container, sidebar);
    }

    public void createNewPage() {
        page.waitForLoadState();
        container.createNewPage();
    }

    public EditorPopUpMenu popUpMenu() {
        return editorPopUpMenu;
    }

    public PageBuilder editPage() {
        return pageBuilder;
    }

    public byte[] takeScreenshot() {
        return page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
    }

}
