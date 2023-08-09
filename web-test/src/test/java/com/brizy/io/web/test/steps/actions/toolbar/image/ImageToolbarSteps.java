package com.brizy.io.web.test.steps.actions.toolbar.image;

import com.brizy.io.web.interactions.page.editor.EditorPage;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.brizy.io.web.test.enums.StorageKey.EDITOR;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ImageToolbarSteps {

    Storage storage;

    @Autowired
    public ImageToolbarSteps(Storage storage) {
        this.storage = storage;
    }

    private EditorPage onEditorPage() {
        return storage.getValue(EDITOR, EditorPage.class);
    }

    @When("get available configurations in the tab '{}' of '{}' toolbar item of the '{}' item from section '{}'")
    public void getAvailableConfigurationInATab(String tabName, String toolbarItemTitle, String itemName, String sectionName) {
        List<String> configurations = onEditorPage().onPageBuilder()._do()
                .findComponent(sectionName, itemName)
                .onToolbar()
                .openTabbedPopup(toolbarItemTitle)
                .openTab(tabName).getConfigurations();
        storage.addValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, configurations);
    }


}
