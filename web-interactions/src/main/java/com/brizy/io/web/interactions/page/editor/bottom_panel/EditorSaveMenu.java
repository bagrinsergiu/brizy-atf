package com.brizy.io.web.interactions.page.editor.bottom_panel;

import com.brizy.io.web.interactions.dto.editor.bottom_panel.SaveDraftMenuItemDto;
import com.brizy.io.web.interactions.element.Span;
import com.brizy.io.web.interactions.properties.editor.bottomPanel.EditorBottomPanelSaveMenu;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class EditorSaveMenu {

    Supplier<List<Locator>> items;
    Supplier<Span> clearLayout;
    Supplier<Span> saveLayout;
    Supplier<Span> publishPage;
    Supplier<Span> switchToDraft;

    public EditorSaveMenu(EditorBottomPanelSaveMenu saveMenu, Page page) {
        this.items = () -> page.locator(saveMenu.getMenuItems()).all();
        this.clearLayout = () -> new Span(page.locator(saveMenu.getClearLayout()));
        this.saveLayout = () -> new Span(page.locator(saveMenu.getSaveLayout()));
        this.publishPage = () -> new Span(page.locator(saveMenu.getPublishPage()));
        this.switchToDraft = () -> new Span(page.locator(saveMenu.getSwitchToDraft()));
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

    public void switchToDraft() {
        Span switchToDraftSpan = switchToDraft.get();
        if (switchToDraftSpan.isDisplayed()) {
            switchToDraftSpan.click();
        }
    }

    public List<SaveDraftMenuItemDto> getItems() {
        return items.get().stream()
                .map(locator -> SaveDraftMenuItemDto.builder()
                        .name(locator.textContent())
                        .tooltip(locator.getAttribute("title"))
                        .isEnabled(locator.isEnabled())
                        .build())
                .toList();
    }
}