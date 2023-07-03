package com.brizy.io.web.test.steps.actions;

import com.brizy.io.web.interactions.components.common.GenericComponent;
import com.brizy.io.web.interactions.page.PublishedPage;
import com.brizy.io.web.interactions.properties.WebLocatorsProperties;
import com.brizy.io.web.interactions.properties.publish.PublishPageProperties;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
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
}
