package com.brizy.io.web.test.steps.validations;

import com.brizy.io.web.common.dto.element.type.ItemType;
import com.brizy.io.web.interactions.dto.editor.bottom_panel.EditorBottomPanelItemDto;
import com.brizy.io.web.interactions.dto.editor.bottom_panel.SaveDraftMenuItemDto;
import com.brizy.io.web.interactions.dto.editor.container.right_click_context_menu.ContextMenuItemDto;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.page.editor.EditorPage;
import com.brizy.io.web.test.model.ContextMenuItem;
import com.brizy.io.web.test.model.EditorBottomPanelItem;
import com.brizy.io.web.test.model.SaveDraftMenuItem;
import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.brizy.io.web.test.enums.StorageKey.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ContainerSteps {

    Storage storage;

    @Autowired
    public ContainerSteps(Storage storage) {
        this.storage = storage;
    }

    @Then("^validate default properties of the item '(.*)'$")
    public void validateDefaultPropertiesForAnItem(String item) {
        EditorComponentProperty actualProperties = storage.getValue(COMPONENT_PROPERTIES, EditorComponentProperty.class);
        List<ItemType> expectedProperties = storage.getListValue(PROPERTY_TYPES, ItemType.class);
        Assertions.assertThat(expectedProperties)
                .filteredOn(property -> property.getItemName().equals(item))
                .map(ItemType::getDefaultProperties)
                .first()
                .usingRecursiveComparison()
                .ignoringActualNullFields()
                .ignoringExpectedNullFields()
                .usingDefaultComparator()
                .isEqualTo(actualProperties);
    }

    @Then("(validate that )section '{}' contains '{}' items")
    public void sectionSectionNameContainsItems(String sectionName, Integer expectedNumberOfItems) {
        EditorPage editorPage = storage.getValue(EDITOR, EditorPage.class);
        Assertions.assertThat(editorPage.onPageBuilder()._do().getComponents(sectionName))
                .size()
                .describedAs("Expecting to have <%d> items on section <%s>", expectedNumberOfItems, sectionName)
                .isEqualTo(expectedNumberOfItems);
    }

    @When("validate that the following menu items are displayed:")
    public void validateItems(List<ContextMenuItem> expectedItems) {
        List<ContextMenuItemDto> actualItems = storage.getListValue(MENU_ITEMS, ContextMenuItemDto.class);
        Assertions.assertThat(actualItems)
                .usingRecursiveComparison()
                .ignoringActualNullFields()
                .ignoringExpectedNullFields()
                .usingDefaultComparator()
                .isEqualTo(expectedItems);
    }

    @Then("validate that the following panel items are displayed:")
    public void validateThatTheFollowingPanelItemsAreDisplayed(List<EditorBottomPanelItem> expectedPanelItems) {
        List<EditorBottomPanelItemDto> actualPanelItems = storage.getListValue(EDITOR_BOTTOM_PANEL_ITEMS, EditorBottomPanelItemDto.class);
        Assertions.assertThat(actualPanelItems)
                .usingRecursiveComparison()
                .ignoringActualNullFields()
                .ignoringExpectedNullFields()
                .usingDefaultComparator()
                .describedAs("Expecting to have items displayed on bottom panel")
                .isEqualTo(expectedPanelItems);
    }

    @Then("validate that the following items are displayed on save draft menu:")
    public void validateThatTheFollowingItemsAreDisplayed(List<SaveDraftMenuItem> expectedSaveDraftMenuItems) {
        List<SaveDraftMenuItemDto> actualSaveDraftMenuItems = storage.getListValue(EDITOR_BOTTOM_PANEL_SAVE_MENU_ITEMS, SaveDraftMenuItemDto.class);
        Assertions.assertThat(actualSaveDraftMenuItems)
                .usingRecursiveComparison()
                .ignoringActualNullFields()
                .ignoringExpectedNullFields()
                .usingDefaultComparator()
                .describedAs("Expecting to have items displayed on save draft menu")
                .isEqualTo(expectedSaveDraftMenuItems);
    }
/**
 * To be used <b>only</b> together with {@link com.brizy.io.web.test.steps.actions.ContainerSteps#getItemPropertiesForCompare(StorageKey, String, String)}
 */
    @Then("compare and validate properties for the items")
    public void compareAndValidatePropertiesForTheItems() {
        EditorComponentProperty firstToCompare = storage.getValue(FIRST, EditorComponentProperty.class);
        EditorComponentProperty secondToCompare = storage.getValue(SECOND, EditorComponentProperty.class);
        Assertions.assertThat(firstToCompare)
                .describedAs("Expecting to have the same properties after pasting the  styles for both items")
                .isEqualTo(secondToCompare);
    }
}
