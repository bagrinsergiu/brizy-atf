package com.brizy.io.web.test.steps.actions;

import com.brizy.io.web.interactions.page.EditorPage;
import com.brizy.io.web.interactions.properties.WebLocatorsProperties;
import com.brizy.io.web.interactions.properties.editor.EditorPageProperties;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.When;
import io.vavr.control.Option;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.brizy.io.web.test.enums.StorageKey.PAGE_SECTIONS;
import static java.util.List.of;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPageSteps {

    EditorPageProperties editorPageProperties;
    Storage storage;

    @Autowired
    public EditorPageSteps(WebLocatorsProperties webLocatorsProperties, Storage storage) {
        this.editorPageProperties = webLocatorsProperties.getEditor();
        this.storage = storage;
    }

    @When("open editor pop up")
    public void addSectionOnThePage() {
        EditorPage editorPage = storage.getValue(StorageKey.EDITOR, EditorPage.class);
        editorPage.onPageBuilder()._do().and().openPopUpMenu();
    }

    @When("^switch to '(.*)' tab$")
    public void switchToBlocksTab(String tab) {
        EditorPage editorPage = storage.getValue(StorageKey.EDITOR, EditorPage.class);
        editorPage.onPopUpMenu().switchToTab(tab);
    }

    @When("^add section '(.*)' to page$")
    public void addSectionToPage(String sectionName) {
        List<String> addedSections = new ArrayList<>(of(sectionName));
        EditorPage editorPage = storage.getValue(StorageKey.EDITOR, EditorPage.class);
        editorPage.onPopUpMenu().createYourOwn();
        editorPage.onPageBuilder()._do().addSection(sectionName);
        Option.of(storage.getValue(PAGE_SECTIONS, List.class))
                .peek(addedSections::addAll)
                .onEmpty(() -> storage.addValue(PAGE_SECTIONS, addedSections));
    }

    @When("wait for editor page to load")
    public void waitForEditorPageToLoad() {
        Page page = storage.getValue(StorageKey.INIT_PAGE, Page.class);
        EditorPage editorPage = new EditorPage(editorPageProperties, page);
        storage.addValue(StorageKey.EDITOR, editorPage);
        storage.addValue(StorageKey.EDITOR_PAGE, page);
    }

}