package com.brizy.io.web.test.steps.validations.toolbar;

import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.functional.Attachment;
import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.en.Then;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.Assertions;

import java.util.List;

import static com.brizy.io.web.test.enums.StorageKey.DROPDOWN_ITEMS;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ToolbarSteps {

    Storage storage;

    public ToolbarSteps(Storage storage) {
        this.storage = storage;
    }

    @Attachment
    @Then("the following toolbar items should be displayed:")
    public void theFollowingToolbarItemsShouldBeDisplayed(List<String> expectedToolbarItems) {
        List<String> actualToolbarItems = storage.getListValue(StorageKey.TOOLBAR_ITEMS, String.class);
        Assertions.assertThat(actualToolbarItems)
                .describedAs("Expecting to have the following items <%s> displayed on the toolbar", expectedToolbarItems)
                .containsExactlyElementsOf(expectedToolbarItems);
    }

    @Attachment
    @Then("the following tabs should be displayed in the opened popup: {}")
    public void theFollowingTabsShouldBeDisplayedInTheOpenedPopup(String expectedTabsToBeDisplayed) {
        List<String> actualTabsToBeDisplayed = storage.getListValue(StorageKey.TABS_LIST, String.class);
        Assertions.assertThat(expectedTabsToBeDisplayed.split(","))
                .extracting(String::trim)
                .describedAs("Expecting to have the following tabs <%s> displayed on the popup", expectedTabsToBeDisplayed)
                .containsExactlyElementsOf(actualTabsToBeDisplayed);
    }

    @Attachment
    @Then("dropdown contains the following values:")
    public void dropdownShouldContainsTheFollowingValues(List<String> expectedDropdownValues) {
        List<String> actualValues = storage.getListValue(DROPDOWN_ITEMS, String.class);
        Assertions.assertThat(expectedDropdownValues)
                .describedAs("Expecting the following dropdown values: <%s>", expectedDropdownValues)
                .containsExactlyElementsOf(actualValues);
    }

}
