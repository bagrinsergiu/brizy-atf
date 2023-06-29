package com.brizy.io.web.test.steps;

import com.brizy.io.web.interactions.properties.WebLocatorsProperties;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PublishPageSteps {

    Storage storage;

    @Autowired
    public PublishPageSteps(WebLocatorsProperties webLocatorsProperties, Storage storage) {
        this.storage = storage;
    }

    @Then("validate item properties")
    public void validateItemProperties() {
        Page publishPage = storage.getValue(StorageKey.PUBLISH_PAGE, Page.class);
        byte[] screenshot = publishPage.screenshot();
        Allure.addAttachment("Published page", new ByteArrayInputStream(screenshot));
    }
}
