package com.brizy.io.web.test.steps.actions;

import com.brizy.io.web.interactions.locators.WebLocatorsProperties;
import com.brizy.io.web.interactions.locators.publish.PublishPageLocators;
import com.brizy.io.web.interactions.page.common.GenericComponent;
import com.brizy.io.web.interactions.page.editor.EditorPage;
import com.brizy.io.web.interactions.page.publish.PublishedPage;
import com.brizy.io.web.interactions.page.publish.section.items.Form;
import com.brizy.io.web.interactions.page.publish.section.items.form.item.Date;
import com.brizy.io.web.interactions.page.publish.section.items.form.item.Email;
import com.brizy.io.web.interactions.page.publish.section.items.form.item.Number;
import com.brizy.io.web.interactions.page.publish.section.items.form.item.Text;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static com.brizy.io.web.test.enums.StorageKey.EDITOR;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PublishPageSteps {

    PublishPageLocators publishPageLocators;
    Storage storage;

    @Autowired
    public PublishPageSteps(WebLocatorsProperties webLocatorsProperties, Storage storage) {
        this.publishPageLocators = webLocatorsProperties.getPublish();
        this.storage = storage;
    }

    @When("get published items on section '{}'")
    public void validateItemProperties(String sectionName) {
        Page publishPage = storage.getValue(StorageKey.PUBLISH_PAGE, Page.class);
        PublishedPage publishedPage = new PublishedPage(publishPageLocators, publishPage);
        EditorPage editorPage = storage.getValue(EDITOR, EditorPage.class);
        var uuidToSearchFor = editorPage.onPageBuilder()._do().getSection(sectionName).getUuid();
        List<GenericComponent> components = publishedPage.findSectionByUuid(uuidToSearchFor).getComponents();
        storage.addValue(StorageKey.PUBLISHED_COMPONENTS, components);
    }

    @When("get published item of type '{}'")
    public void getPublishedItemWithNameName(String itemName) {
        var publishedItems = storage.getListValue(StorageKey.PUBLISHED_COMPONENTS, GenericComponent.class);
        var genericComponent = publishedItems.stream()
                .filter(el -> el.getClass().equals(Form.class))
                .findFirst()
                .get();
        storage.addValue(StorageKey.FOUND_COMPONENT, genericComponent);
    }

    @When("get form {formItem} item by placeholder '{}'")
    public void getFormItemByPlaceholder(Class<?> formItem, String placeholder) {
        var foundComponent = storage.getValue(StorageKey.FOUND_COMPONENT, Form.class);
        var foundItem = foundComponent.findSelectItemByPlaceholder(formItem, placeholder);
        storage.addValue(StorageKey.FOUND_COMPONENT, foundItem);
    }

    @When("fill text form field with content '{customString}'")
    public void addToTextFormFromTheField(String customString) {
        var item = storage.getValue(StorageKey.FOUND_COMPONENT, Text.class);
        item.setContent(customString);
        storage.addValue(StorageKey.GENERIC_STRING, customString);
        Allure.getLifecycle().addAttachment("Random string value", "text/plain", ".log", customString.getBytes());
    }

    @When("fill email form field with content '{customString}'")
    public void addToEmailFormFromTheField(String customString) {
        var item = storage.getValue(StorageKey.FOUND_COMPONENT, Email.class);
        item.setContent(customString);
        storage.addValue(StorageKey.GENERIC_STRING, customString);
        Allure.getLifecycle().addAttachment("Random string value", "text/plain", ".log", customString.getBytes());
    }

    @When("fill date form field with content '{}'")
    public void addToDateFormFromTheField(String valueToSet) {
        var item = storage.getValue(StorageKey.FOUND_COMPONENT, Date.class);
        item.setContent(LocalDate.parse(valueToSet));
        storage.addValue(StorageKey.GENERIC_LOCAL_DATE, valueToSet);
    }

    @When("fill number form field with value '{}'")
    public void addToNumberFormFromTheField(Long value) {
        var item = storage.getValue(StorageKey.FOUND_COMPONENT, Number.class);
        item.setValue(value);
        storage.addValue(StorageKey.GENERIC_LONG, value);
    }

    @When("get the content of the form text field")
    public void getTheContentOfFormTextField() {
        var item = storage.getValue(StorageKey.FOUND_COMPONENT, Text.class);
        storage.addValue(StorageKey.FORM_FIELD_CONTENT, item.getContent());
    }

    @When("get the content of the form email field")
    public void getTheContentOfFormEmailField() {
        var item = storage.getValue(StorageKey.FOUND_COMPONENT, Email.class);
        storage.addValue(StorageKey.FORM_FIELD_CONTENT, item.getContent());
    }

    @When("get the content of the form date field")
    public void getTheContentOfFormDateField() {
        var item = storage.getValue(StorageKey.FOUND_COMPONENT, Date.class);
        storage.addValue(StorageKey.FORM_FIELD_CONTENT, item.getContent());
    }

    @When("get the value of the form number field")
    public void getTheContentOfFormNumberField() {
        var item = storage.getValue(StorageKey.FOUND_COMPONENT, Number.class);
        storage.addValue(StorageKey.FORM_FIELD_CONTENT, item.getValue());
    }

}
