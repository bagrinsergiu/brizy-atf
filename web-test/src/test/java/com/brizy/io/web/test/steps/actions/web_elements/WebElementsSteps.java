package com.brizy.io.web.test.steps.actions.web_elements;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.element.Input;
import com.brizy.io.web.interactions.element.composite.InputWithPopulation;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.page.editor.EditorPage;
import com.brizy.io.web.test.data.enums.TestDataFileType;
import com.brizy.io.web.test.data.service.TestDataFileService;
import com.brizy.io.web.test.enums.AttributeTypes;
import com.brizy.io.web.test.enums.RadioGroupActions;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.Path;
import java.util.List;
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

    @When("get {attribute} content of '{}' dropdown")
    public void getTheContentOfDropdown(AttributeTypes attributeType, String dropdown) {
        List<Configuration> availableConfigurations = storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class);
        List<String> dropdownItems = availableConfigurations.stream()
                .filter(configuraion -> configuraion.getName().equals(dropdown))
                .flatMap(configuration -> ((ComboBox) configuration.getElement().get()).items(locator -> true, attributeType.getExtractionFunction()).stream())
                .toList();
        storage.addValue(DROPDOWN_ITEMS, dropdownItems);
    }

    @When("get {radioGroupAction} item(s) from '{}' radio group")
    public void getSelectedItemFromStyleRadioGroup(RadioGroupActions radioGroupAction, String radioGroup) {
        storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class).stream()
                .filter(el -> el.getName().equals(radioGroup))
                .findFirst()
                .map(configuration -> configuration.getElement())
                .map(configuration -> ((RadioControl) configuration.get()))
                .map(radioControl -> radioControl.getActiveControl())
                .map(radioControl -> radioControl.name())
                .ifPresent(activeValue -> storage.addValue(StorageKey.VALUE, activeValue));
    }

    @When("get value of the '{}' input with population")
    public void getValueFromStyleInputWithPopulation(String inputWithPopulationToCheck) {
        storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class).stream()
                .filter(el -> el.getName().equals(inputWithPopulationToCheck))
                .findFirst()
                .map(configuration -> configuration.getElement())
                .map(configuration -> ((InputWithPopulation) configuration.get()))
                .map(input -> input.getInputValue())
                .ifPresent(activeValue -> storage.addValue(StorageKey.VALUE, activeValue));
    }

    @When("get value of the '{}' input")
    public void getValueOfTheDurationInput(String inputToCheck) {
        storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class).stream()
                .filter(el -> el.getName().equals(inputToCheck))
                .findFirst()
                .map(configuration -> configuration.getElement())
                .map(configuration -> ((Input) configuration.get()))
                .map(input -> input.getRawValue())
                .ifPresent(activeValue -> storage.addValue(StorageKey.VALUE, activeValue));
    }

}
