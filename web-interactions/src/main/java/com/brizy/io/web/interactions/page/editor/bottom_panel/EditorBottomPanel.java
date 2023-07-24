package com.brizy.io.web.interactions.page.editor.bottom_panel;

import com.brizy.io.web.interactions.dto.editor.bottom_panel.EditorBottomPanelItemDto;
import com.brizy.io.web.interactions.element.Button;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class EditorBottomPanel {

    Supplier<Button> showHiddenElements;
    Supplier<Button> undo;
    Supplier<Button> redo;
    Supplier<Button> preview;
    Supplier<Button> saveDraft;
    Supplier<Button> saveDraftButton;
    EditorSaveMenu editorSaveMenu;

    public EditorBottomPanel(com.brizy.io.web.interactions.properties.editor.bottomPanel.EditorBottomPanel properties, Page page) {
        this.showHiddenElements = () -> new Button(page.locator(properties.getShowHiddenElements()));
        this.undo = () -> new Button(page.locator(properties.getUndo()));
        this.redo = () -> new Button(page.locator(properties.getRedo()));
        this.preview = () -> new Button(page.locator(properties.getPreview()));
        this.saveDraft = () -> new Button(page.locator(properties.getSaveDraft()));
        this.saveDraftButton = () -> new Button(page.locator(properties.getSaveDraftButton()));
        this.editorSaveMenu = new EditorSaveMenu(properties.getSaveMenu(), page);
    }

    public void showHiddenElements() {
        showHiddenElements.get().click();
    }

    public void undo() {
        undo.get().click();
    }

    public void redo() {
        redo.get().click();
    }

    public void preview() {
        preview.get().click();
    }

    public void saveDraft() {
        saveDraft.get().click();
    }

    public EditorSaveMenu openSaveMenu() {
        saveDraftButton.get().click();
        return editorSaveMenu;
    }

    public List<EditorBottomPanelItemDto> getItems() {
        Button showHiddenElements = this.showHiddenElements.get();
        Button undo = this.undo.get();
        Button redo = this.redo.get();
        Button preview = this.preview.get();
        return List.of(
                EditorBottomPanelItemDto.builder().name("ShowHiddenElements").tooltip(showHiddenElements.tooltip()).isEnabled(showHiddenElements.getAttribute("class").contains("active")).build(),
                EditorBottomPanelItemDto.builder().name("Undo").tooltip(undo.tooltip()).isEnabled(undo.getAttribute("class").contains("active")).build(),
                EditorBottomPanelItemDto.builder().name("Redo").tooltip(redo.tooltip()).isEnabled(redo.getAttribute("class").contains("active")).build(),
                EditorBottomPanelItemDto.builder().name("Preview").tooltip(preview.tooltip()).isEnabled(preview.getAttribute("class").contains("active")).build()
        );
    }

}