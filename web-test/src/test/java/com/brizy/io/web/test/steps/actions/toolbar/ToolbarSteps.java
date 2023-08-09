package com.brizy.io.web.test.steps.actions.toolbar;

import com.brizy.io.web.interactions.page.editor.EditorPage;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static com.brizy.io.web.test.enums.StorageKey.EDITOR;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SuppressWarnings("all")
public class ToolbarSteps {

    Storage storage;

    public ToolbarSteps(Storage storage) {
        this.storage = storage;
    }

    private EditorPage onEditorPage() {
        return storage.getValue(EDITOR, EditorPage.class);
    }

    @When("get the toolbar items for '{}' item from section '{}'")
    public void getTheToolbarItemsForNameItemFromSection(String itemName, String sectionName) {
        List<String> toolbarItems = onEditorPage().onPageBuilder()._do()
                .findComponent(sectionName, itemName)
                .onToolbar()
                .getItems();
        storage.addValue(StorageKey.TOOLBAR_ITEMS, toolbarItems);
    }

    @When("get tabs list from '{}' toolbar item for '{}' item from section '{}'")
    public void openToolbarItemForItemFromSection(String toolbarItemTitle, String itemName, String sectionName) {
        List<String> tabsList = onEditorPage().onPageBuilder()._do()
                .findComponent(sectionName, itemName)
                .onToolbar()
                .openTabbedPopup(toolbarItemTitle)
                .getTabs();
        storage.addValue(StorageKey.TABS_LIST, tabsList);
    }

}
