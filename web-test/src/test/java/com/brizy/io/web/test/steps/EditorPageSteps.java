package com.brizy.io.web.test.steps;

import com.brizy.io.web.interactions.page.EditorPage;
import com.brizy.io.web.interactions.properties.WebLocatorsProperties;
import com.brizy.io.web.interactions.properties.editor.EditorPageProperties;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import com.brizy.io.web.test.tools.PageReload;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EditorPageSteps {

    EditorPageProperties editorPageProperties;
    Storage storage;

    @Autowired
    public EditorPageSteps(WebLocatorsProperties webLocatorsProperties, Storage storage) {
        this.editorPageProperties = webLocatorsProperties.getEditor();
        this.storage = storage;
    }

    @When("start building a new page")
    public void startBuildingANewPage() {
        Page page = PageReload.reloadAndGetPage(storage.getValue(StorageKey.DASHBOARD_PAGE, Page.class));
        EditorPage editorPage = new EditorPage(editorPageProperties, page);
        editorPage.createNewPage();
        storage.addValue(StorageKey.EDITOR_PAGE, editorPage);
    }

    @When("^switch to '(.*)' tab$")
    public void switchToBlocksTab(String tab) {
        EditorPage editorPage = storage.getValue(StorageKey.EDITOR_PAGE, EditorPage.class);
        editorPage.popUpMenu().switchToTab(tab);
    }

    @When("select create your own block")
    public void selectCreateYourOwnBlock() {
        EditorPage editorPage = storage.getValue(StorageKey.EDITOR_PAGE, EditorPage.class);
        editorPage.popUpMenu().createYourOwn();
    }

}
