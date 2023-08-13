package com.brizy.io.web.test.steps.actions.web_elements;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.page.editor.EditorPage;
import com.brizy.io.web.test.data.enums.TestDataFileType;
import com.brizy.io.web.test.data.service.TestDataFileService;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.util.Strings;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static com.brizy.io.web.test.enums.StorageKey.DROPDOWN_ITEMS;
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

    @When("upload the file '{}' to '{}' configuration")
    public void uploadTheFileTo(String filePath, String configurationName) {
        Path resourceFilePath = testDataFileService.getResourceFilePath(TestDataFileType.FILE, filePath);
        List<Configuration> availableConfigurations = storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class);
        availableConfigurations.stream()
                .filter(configuration -> configuration.getName().equals(configurationName))
                .findFirst()
                .ifPresent(configuration -> {
                    Supplier<FileUploader> element = (Supplier<FileUploader>) configuration.getElement();
                    element.get().uploadFile(resourceFilePath);
                });
    }

    @When("get the content of '{}' dropdown")
    public void getTheContentOfDropdown(String dropdown) {
        List<Configuration> availableConfigurations = storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class);
        List<String> dropdownItems = availableConfigurations.stream()
                .filter(configuraion -> configuraion.getName().equals(dropdown))
                .flatMap(configuration -> ((ComboBox) configuration.getElement().get()).items(locator -> true, locator -> Strings.isNullOrEmpty(locator.getAttribute("value")) ? locator.textContent() : locator.getAttribute("value")).stream())
                .toList();
        storage.addValue(DROPDOWN_ITEMS, dropdownItems);
    }

}
