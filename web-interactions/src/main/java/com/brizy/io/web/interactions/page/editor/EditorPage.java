package com.brizy.io.web.interactions.page.editor;

import com.brizy.io.web.interactions.page.AbstractPage;
import com.brizy.io.web.interactions.page.PageBuilder;
import com.brizy.io.web.interactions.page.editor.bottom_panel.EditorBottomPanel;
import com.brizy.io.web.interactions.page.editor.pop_up.EditorPopUpMenu;
import com.brizy.io.web.interactions.properties.editor.EditorPageProperties;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPage extends AbstractPage {

    EditorPopUpMenu editorPopUpMenu;
    EditorBottomPanel bottomPanel;
    Page page;
    PageBuilder pageBuilder;

    public EditorPage(EditorPageProperties editorPageProperties, Page page) {
        super(page);
        this.bottomPanel = new EditorBottomPanel(editorPageProperties.getBottomPanel(), page);
        this.editorPopUpMenu = new EditorPopUpMenu(editorPageProperties.getEditorPopUp(), page);
        this.page = page;
        this.pageBuilder = new PageBuilder(editorPageProperties, page);
    }

    public EditorPopUpMenu onPopUpMenu() {
        return editorPopUpMenu;
    }

    public PageBuilder onPageBuilder() {
        return pageBuilder;
    }

    public EditorBottomPanel onBottomPanel() {
        return bottomPanel;
    }

}
