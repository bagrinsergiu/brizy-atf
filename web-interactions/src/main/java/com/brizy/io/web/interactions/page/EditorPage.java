package com.brizy.io.web.interactions.page;

import com.brizy.io.web.interactions.components.editor.bottom_panel.EditorBottomPanel;
import com.brizy.io.web.interactions.components.editor.pop_up.EditorPopUpMenu;
import com.brizy.io.web.interactions.properties.editor.EditorPageProperties;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPage {

    EditorPopUpMenu editorPopUpMenu;
    EditorBottomPanel bottomPanel;
    Page page;
    PageBuilder pageBuilder;

    public EditorPage(EditorPageProperties editorPageProperties, Page page) {
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

    public byte[] takeScreenshot() {
        return page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
    }

    public EditorBottomPanel onBottomPanel() {
        return bottomPanel;
    }

    public void waitForDomToBeLoaded() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

}
