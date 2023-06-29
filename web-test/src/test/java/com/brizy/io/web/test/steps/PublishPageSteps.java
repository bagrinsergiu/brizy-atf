package com.brizy.io.web.test.steps;

import com.brizy.io.web.interactions.properties.WebLocatorsProperties;
import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PublishPageSteps {

    Storage storage;

    @Autowired
    public PublishPageSteps(WebLocatorsProperties webLocatorsProperties, Storage storage) {
        this.storage = storage;
    }

    @Then("validate item properties")
    public void validateItemProperties() {

    }
}
