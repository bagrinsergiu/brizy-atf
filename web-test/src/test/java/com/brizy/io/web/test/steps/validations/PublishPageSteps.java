package com.brizy.io.web.test.steps.validations;

import com.brizy.io.web.interactions.locators.WebLocatorsProperties;
import com.brizy.io.web.interactions.locators.publish.PublishPageLocators;
import com.brizy.io.web.interactions.page.common.GenericComponent;
import com.brizy.io.web.interactions.page.publish.section.items.form.item.Select;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PublishPageSteps {

    PublishPageLocators publishPageLocators;
    Storage storage;

    @Autowired
    public PublishPageSteps(WebLocatorsProperties webLocatorsProperties, Storage storage) {
        this.publishPageLocators = webLocatorsProperties.getPublish();
        this.storage = storage;
    }

    @Then("validate css properties of the components")
    public void validateCssItemProperties() {
        Page publishPage = storage.getValue(StorageKey.PUBLISH_PAGE, Page.class);
//        PublishedPage publishedPage = new PublishedPage(publishPageProperties, publishPage);
//        List<GenericComponent> components = publishedPage.getSections().get(0).getComponents();
//        CssProperties expected = components.get(0).getProperties();
//        CssProperties actual = storage.getValue(StorageKey.CSS_EDITOR_COMPONENT_PROPERTIES, CssProperties.class);
//        Assertions.assertThat(expected)
//                .usingRecursiveComparison()
//                .ignoringExpectedNullFields()
//                .ignoringActualNullFields()
//                .isEqualTo(actual);
//        byte[] screenshot = publishPage.screenshot();
//        Allure.addAttachment("Published page", new ByteArrayInputStream(screenshot));
    }

    @Then("should have '{}' item(s) published")
    public void shouldHavePublishedOnlyOneItem(Integer expectedPublishedItems) {
        var actualSize = storage.getListValue(StorageKey.PUBLISHED_COMPONENTS, GenericComponent.class).size();
        Assertions.assertThat(actualSize)
                .describedAs("Expected to have {} items published", expectedPublishedItems)
                .isEqualTo(expectedPublishedItems);
    }

    @Then("should see the following select items:")
    public void shouldSeeTheFollowingSelectItems(List<String> selectItems) {
        var value = storage.getValue(StorageKey.FOUND_COMPONENT, Select.class);
        var items = value.getItems();
    }
}
