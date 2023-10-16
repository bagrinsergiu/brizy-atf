package com.brizy.io.web.test.steps.actions;

import com.brizy.io.web.interactions.locators.WebLocatorsProperties;
import com.brizy.io.web.interactions.locators.publish.PublishPageLocators;
import com.brizy.io.web.interactions.page.common.GenericComponent;
import com.brizy.io.web.interactions.page.editor.EditorPage;
import com.brizy.io.web.interactions.page.publish.PublishedPage;
import com.brizy.io.web.interactions.page.publish.section.items.Form;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

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

    @When("get form select item by placeholder '{}'")
    public void getFormItemByPlaceholder(String placeholder) {
        var foundComponent = storage.getValue(StorageKey.FOUND_COMPONENT, Form.class);
        var foundItem = foundComponent.findSelectItemByPlaceholder(placeholder);
        storage.addValue(StorageKey.FOUND_COMPONENT, foundItem);
    }

}
