package com.brizy.io.web.test.steps.actions;

import com.brizy.io.web.interactions.dto.editor.container.properties.CssProperties;
import com.brizy.io.web.interactions.locators.WebLocatorsProperties;
import com.brizy.io.web.interactions.locators.publish.PublishPageProperties;
import com.brizy.io.web.interactions.page.common.GenericComponent;
import com.brizy.io.web.interactions.page.publish.PublishedPage;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PublishPageSteps {

    PublishPageProperties publishPageProperties;
    Storage storage;

    @Autowired
    public PublishPageSteps(WebLocatorsProperties webLocatorsProperties, Storage storage) {
        this.publishPageProperties = webLocatorsProperties.getPublish();
        this.storage = storage;
    }

    @Then("validate item properties")
    public void validateItemProperties() {
        Page publishPage = storage.getValue(StorageKey.PUBLISH_PAGE, Page.class);
        PublishedPage publishedPage = new PublishedPage(publishPageProperties, publishPage);
        List<GenericComponent> components = publishedPage.getSections().get(0).getComponents();
        byte[] screenshot = publishPage.screenshot();
        Allure.addAttachment("Published page", new ByteArrayInputStream(screenshot));
    }

    @Then("validate css properties of the components")
    public void validateCssItemProperties() {
        Page publishPage = storage.getValue(StorageKey.PUBLISH_PAGE, Page.class);
        PublishedPage publishedPage = new PublishedPage(publishPageProperties, publishPage);
        List<GenericComponent> components = publishedPage.getSections().get(0).getComponents();
        CssProperties expected = components.get(0).getProperties();
        CssProperties actual = storage.getValue(StorageKey.CSS_EDITOR_COMPONENT_PROPERTIES, CssProperties.class);
        Assertions.assertThat(expected)
                .usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .ignoringActualNullFields()
                .isEqualTo(actual);
        byte[] screenshot = publishPage.screenshot();
        Allure.addAttachment("Published page", new ByteArrayInputStream(screenshot));
    }
}
