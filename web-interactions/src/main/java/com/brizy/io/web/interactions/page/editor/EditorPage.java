package com.brizy.io.web.interactions.page.editor;

import com.brizy.io.web.interactions.locators.editor.EditorPageLocators;
import com.brizy.io.web.interactions.page.AbstractPage;
import com.brizy.io.web.interactions.page.PageBuilder;
import com.brizy.io.web.interactions.page.editor.bottom_panel.EditorBottomPanel;
import com.brizy.io.web.interactions.page.editor.pop_up.EditorPopUpMenu;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPage extends AbstractPage {

    EditorPopUpMenu editorPopUpMenu;
    EditorBottomPanel bottomPanel;
    Page page;
    PageBuilder pageBuilder;
    Supplier<Locator> alertLocators;
    Supplier<Locator> errorLocator;

    public EditorPage(EditorPageLocators editorPageLocators, Page page) {
        super(page);
        this.bottomPanel = new EditorBottomPanel(editorPageLocators.getBottomPanel(), page);
        this.editorPopUpMenu = new EditorPopUpMenu(editorPageLocators.getEditorPopUp(), page);
        this.alertLocators = () -> page.locator(editorPageLocators.getAlert());
        this.errorLocator = () -> page.locator(editorPageLocators.getError());
        this.page = page;
        this.pageBuilder = new PageBuilder(editorPageLocators, page);
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

    public List<String> getAlerts() {
        return alertLocators.get().all().stream()
                .map(Locator::textContent)
                .toList();
    }

    public boolean errorIsDisplayed() {
        return errorLocator.get().count() > 0;
    }

    public boolean waitForAlertToAppear() {
        page.waitForCondition(() -> !alertLocators.get().all().isEmpty(), new Page.WaitForConditionOptions().setTimeout(2000));
        return true;
    }
}
