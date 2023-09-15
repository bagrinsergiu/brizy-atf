package com.brizy.io.web.test.steps.validations.toolbar.image;

import com.brizy.io.web.interactions.page.editor.EditorPage;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.functional.Attachment;
import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.Assertions;
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


    @Then("the following configurations should be displayed: {}")
    public void theFollowingConfigurationsShouldBeDisplayed(String configurationToBeDisplayed) {
        List<String> actualDisplayedConfigurations = storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_WEB_CONFIGURATIONS, String.class);
        Assertions.assertThat(configurationToBeDisplayed.split(","))
                .extracting(String::trim)
                .describedAs("Expecting to have the following configurations <%s> ", configurationToBeDisplayed)
                .containsExactlyElementsOf(actualDisplayedConfigurations);
    }

}
