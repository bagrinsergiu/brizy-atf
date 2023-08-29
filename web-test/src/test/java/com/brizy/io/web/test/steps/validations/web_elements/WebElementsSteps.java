package com.brizy.io.web.test.steps.validations.web_elements;

import com.brizy.io.web.interactions.page.editor.EditorPage;
import com.brizy.io.web.test.data.service.TestDataFileService;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import static com.brizy.io.web.test.enums.StorageKey.EDITOR;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SuppressWarnings("all")
public class WebElementsSteps {

    Storage storage;
    TestDataFileService testDataFileService;

    @Autowired
    public WebElementsSteps(Storage storage, TestDataFileService testDataFileService) {
        this.testDataFileService = testDataFileService;
        this.storage = storage;
    }

    private EditorPage onEditorPage() {
        return storage.getValue(EDITOR, EditorPage.class);
    }

    @Then("the following item is active: {}")
    public void theFollowingItemIsDispalyed(String expectedActiveItem) {
        Assertions.assertThat(expectedActiveItem)
                .describedAs("Expecting to have <%s> active radio control", expectedActiveItem)
                .isEqualToIgnoringCase(storage.getValue(StorageKey.VALUE, String.class));
    }

}
