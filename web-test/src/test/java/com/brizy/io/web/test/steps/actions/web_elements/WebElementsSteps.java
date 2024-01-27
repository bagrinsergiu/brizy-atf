package com.brizy.io.web.test.steps.actions.web_elements;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.*;
import com.brizy.io.web.interactions.element.composite.DropdownWithPopulation;
import com.brizy.io.web.interactions.element.composite.InputWithPopulation;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.page.editor.EditorPage;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon.size.IconSize;
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

import static com.brizy.io.web.test.enums.StorageKey.*;

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
                .filter(configuration -> configuration.getName().equalsIgnoreCase(configurationName))
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
                .filter(configuraion -> configuraion.getName().equalsIgnoreCase(dropdown))
                .flatMap(configuration -> ((ComboBox) configuration.getElement().get()).items(locator -> true, attributeType.getExtractionFunction()).stream())
                .toList();
        storage.addValue(DROPDOWN_ITEMS, dropdownItems);
    }

    @When("set '{}' value for '{}' dropdown")
    public void setValueOfDropdown(String value, String dropdown) {
        List<Configuration> availableConfigurations = storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class);
        availableConfigurations.stream()
                .filter(configuraion -> configuraion.getName().equals(dropdown))
                .findFirst()
                .map(foundDropdown -> ((ComboBox) foundDropdown.getElement().get()))
                .ifPresent(foundDropdown -> foundDropdown.selectItemByName(value));
    }

    @When("set '{}' as value for '{}' dropdown")
    public void setByValueOfDropdown(String value, String dropdown) {
        List<Configuration> availableConfigurations = storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class);
        availableConfigurations.stream()
                .filter(configuraion -> configuraion.getName().equals(dropdown))
                .findFirst()
                .map(foundDropdown -> ((ComboBox) foundDropdown.getElement().get()))
                .ifPresent(foundDropdown -> foundDropdown.selectItemByValue(value));
    }

    @When("set '{}' value for '{}' text input")
    public void setValueOfTextInput(String value, String textInput) {
        List<Configuration> availableConfigurations = storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class);
        availableConfigurations.stream()
                .filter(configuraion -> configuraion.getName().equals(textInput))
                .findFirst()
                .map(foundDropdown -> ((TextInput) foundDropdown.getElement().get()))
                .ifPresent(foundDropdown -> foundDropdown.fill(value));
    }

    @When("get selected value of the '{}' dropdown")
    public void getActiveValueOfDropDown(String dropdown) {
        storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class).stream()
                .filter(configuraion -> configuraion.getName().equalsIgnoreCase(dropdown))
                .map(configuration -> ((ComboBox) configuration.getElement().get()))
                .map(el -> el.getSelectedItem())
                .findFirst()
                .ifPresent(selectedItem -> storage.addValue(VALUE, selectedItem));
    }

    @When("get {radioGroupAction} item(s) from '{}' radio group")
    public void getSelectedItemFromStyleRadioGroup(RadioGroupActions radioGroupAction, String radioGroup) {
        var foundRadioControl = storage.getListValue(TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class).stream()
                .filter(el -> el.getName().equalsIgnoreCase(radioGroup))
                .findFirst()
                .map(configuration -> configuration.getElement())
                .map(configuration -> ((RadioControl) configuration.get()));
        if (radioGroupAction.equals(RadioGroupActions.ACTIVE)) {
            foundRadioControl
                    .map(radioControl -> radioControl.getActiveControl())
                    .map(radioControl -> radioControl.name())
                    .ifPresent(activeValue -> storage.addValue(StorageKey.VALUE, activeValue));
        } else {
            foundRadioControl
                    .map(radioControl -> radioControl.getAllControls())
                    .ifPresent(activeValue -> storage.addValue(StorageKey.VALUE, activeValue));
        }
    }

    @When("get {radioGroupAction} item(s) from '{}' size")
    public void getSelectedItemFromSizeItem(RadioGroupActions radioGroupAction, String size) {
        var foundSize = storage.getListValue(TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class).stream()
                .filter(el -> el.getName().equalsIgnoreCase(size))
                .findFirst()
                .map(configuration -> configuration.getElement())
                .map(configuration -> ((IconSize) configuration.get()));
        if (radioGroupAction.equals(RadioGroupActions.ACTIVE)) {
            foundSize
                    .map(el -> el.getRadioControl())
                    .map(radioControl -> radioControl.getActiveControl().name())
                    .ifPresent(activeValue -> storage.addValue(StorageKey.VALUE, activeValue));
        } else {
            foundSize
                    .map(el -> el.getRadioControl())
                    .map(radioControl -> radioControl.getAllControls())
                    .ifPresent(activeValue -> storage.addValue(StorageKey.VALUE, activeValue));
        }
    }

    @When("get from '{}' item custom size")
    public void getCustomSizeFromItem(String size) {
        storage.getListValue(TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class).stream()
                .filter(el -> el.getName().equalsIgnoreCase(size))
                .findFirst()
                .map(configuration -> configuration.getElement())
                .map(configuration -> ((IconSize) configuration.get()))
                .map(foundSize -> foundSize.getCustomSize())
                .ifPresent(activeValue -> storage.addValue(StorageKey.VALUE, activeValue));
    }

    @When("get numeric input with name '{}'")
    public void getNumericInput(String numericInput) {
        storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class).stream()
                .filter(el -> el.getName().equalsIgnoreCase(numericInput))
                .findFirst()
                .map(configuration -> configuration.getElement())
                .map(configuration -> ((NumericInput) configuration.get()))
                .ifPresent(activeValue -> storage.addValue(StorageKey.VALUE, activeValue));
    }

    @When("get value of the '{}' input with population")
    public void getValueOfInputWithPopulation(String inputWithPopulationToCheck) {
        storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class).stream()
                .filter(el -> el.getName().equalsIgnoreCase(inputWithPopulationToCheck))
                .findFirst()
                .map(configuration -> configuration.getElement())
                .map(configuration -> ((InputWithPopulation) configuration.get()))
                .map(input -> input.getInputValue())
                .ifPresent(activeValue -> storage.addValue(StorageKey.VALUE, activeValue));
    }

    @When("get value of the '{}' dropdown with population")
    public void getValueOfDropdownWithPopulation(String inputWithPopulationToCheck) {
        storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class).stream()
                .filter(el -> el.getName().equalsIgnoreCase(inputWithPopulationToCheck))
                .findFirst()
                .map(configuration -> configuration.getElement())
                .map(configuration -> ((DropdownWithPopulation) configuration.get()))
                .map(input -> input.getInputValue())
                .ifPresent(activeValue -> storage.addValue(StorageKey.VALUE, activeValue));
    }

    @When("get value of the '{}' input with units")
    public void getValueFromStyleInputWithUnits(String inputWithPopulationToCheck) {
        storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class).stream()
                .filter(el -> el.getName().equalsIgnoreCase(inputWithPopulationToCheck))
                .findFirst()
                .map(configuration -> configuration.getElement())
                .map(configuration -> ((InputWithUnits) configuration.get()))
                .map(input -> input.getValue().getValue())
                .ifPresent(activeValue -> storage.addValue(StorageKey.VALUE, activeValue));
    }

    @When("get range of values for the '{}' input with units")
    public void getMinValueFromStyleInputWithUnits(String inputWithPopulationToCheck) {
        storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class).stream()
                .filter(el -> el.getName().equalsIgnoreCase(inputWithPopulationToCheck))
                .findFirst()
                .map(configuration -> configuration.getElement())
                .map(configuration -> ((InputWithUnits) configuration.get()))
                .map(input -> input.getValueRange())
                .ifPresent(activeValue -> storage.addValue(StorageKey.RANGE, activeValue));
    }

    @When("get value of the '{}' input")
    public void getValueOfTheDurationInput(String inputToCheck) {
        storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class).stream()
                .filter(el -> el.getName().equalsIgnoreCase(inputToCheck))
                .findFirst()
                .map(configuration -> configuration.getElement())
                .map(configuration -> ((Input) configuration.get()))
                .map(input -> input.getRawValue())
                .ifPresent(activeValue -> storage.addValue(StorageKey.VALUE, activeValue));
    }

    @When("get value of the '{}' slider")
    public void getValueOfTheSlider(String inputToCheck) {
        storage.getListValue(StorageKey.TOOLBAR_POPUP_TAB_CONFIGURATIONS, Configuration.class).stream()
                .filter(el -> el.getName().equalsIgnoreCase(inputToCheck))
                .findFirst()
                .map(configuration -> configuration.getElement())
                .map(configuration -> ((Slider) configuration.get()))
                .map(input -> input.getState())
                .ifPresent(activeValue -> storage.addValue(StorageKey.VALUE, activeValue));
    }

}
