package com.brizy.io.web.interactions.page.editor.bottom_panel;

import com.brizy.io.web.interactions.element.Button;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;

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

}