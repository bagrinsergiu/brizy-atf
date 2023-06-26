package com.brizy.io.web.interactions.element.nested;

import com.brizy.io.web.interactions.element.Span;
import com.brizy.io.web.interactions.properties.editor.bottomPanel.EditorBottomPanelSaveMenu;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class EditorSaveMenu {

    Supplier<Span> clearLayout;
    Supplier<Span> saveLayout;
    Supplier<Span> publishPage;

    public EditorSaveMenu(EditorBottomPanelSaveMenu saveMenu, Page page) {
        this.clearLayout = () -> new Span(page.locator(saveMenu.getClearLayout()));
        this.saveLayout = () -> new Span(page.locator(saveMenu.getSaveLayout()));
        this.publishPage = () -> new Span(page.locator(saveMenu.getPublishPage()));
    }

    public void clearLayout() {
        clearLayout.get().click();
    }

    public void saveLayout() {
        saveLayout.get().click();
    }

    public void publishPage() {
        publishPage.get().click();
    }

}