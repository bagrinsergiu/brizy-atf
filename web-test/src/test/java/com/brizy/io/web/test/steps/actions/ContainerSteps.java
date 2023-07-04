package com.brizy.io.web.test.steps.actions;

import com.brizy.io.web.common.dto.element.type.ItemType;
import com.brizy.io.web.interactions.components.editor.bottom_panel.EditorBottomPanel;
import com.brizy.io.web.interactions.components.editor.bottom_panel.EditorSaveMenu;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.dto.editor.sidebar.SidebarItemDto;
import com.brizy.io.web.interactions.page.EditorPage;
import com.brizy.io.web.test.data.service.TestDataFileService;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.model.page.FileName;
import com.brizy.io.web.test.model.page.Item;
import com.brizy.io.web.test.storage.Storage;
import com.brizy.io.web.test.transformer.ItemTransformer;
import com.brizy.io.web.test.transformer.MapperTransformerUtil;
import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.util.List;

import static com.brizy.io.web.test.enums.StorageKey.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ContainerSteps {

    TestDataFileService testDataFileService;
    Storage storage;

    @Autowired
    public ContainerSteps(Storage storage, TestDataFileService testDataFileService) {
        this.testDataFileService = testDataFileService;
        this.storage = storage;
    }

    @When("prepare the following items to be added to the page:")
    public void prepareTheFollowingItemsToBeAddedToThePage(List<Item> items) {
        storage.addValue(ITEMS_TO_BE_ADDED_TO_THE_PAGE, items);
    }

    @When("prepare elements properties from the '{fileName}' file")
    public void prepareTheFollowingPropertiesForTheItemsToBeAddedToThePage(FileName properties) {
        Scenario currentScenario = storage.getValue(CURRENT_SCENARIO, Scenario.class);
        List<ItemType> itemProperties = testDataFileService.getItemProperties(properties.getFullName(), ItemType[].class).stream()
                .filter(property -> property.getScenarioName().equals(currentScenario.getName()))
                .toList();
        List<Item> itemsToAdd = storage.getListValue(ITEMS_TO_BE_ADDED_TO_THE_PAGE, Item.class);
        List<Item> itemsWithProperties = ItemTransformer.enrichItemsWithProperties.apply(itemsToAdd, itemProperties);
        storage.addValue(ITEMS_TO_BE_ADDED_TO_THE_PAGE, itemsWithProperties);
        storage.addValue(PROPERTY_TYPES, itemProperties);
        Allure.addAttachment("Properties to add", testDataFileService.getFileContent(properties.getFullName()));
    }

    @When("add the item(s) to the page")
    public void addTheItemsToTheSection() {
        EditorPage editorPage = storage.getValue(EDITOR, EditorPage.class);
        List<Item> itemsToAdd = storage.getListValue(ITEMS_TO_BE_ADDED_TO_THE_PAGE, Item.class);
        List<SidebarItemDto> sidebarItemsToAdd = MapperTransformerUtil.getSidebarItemsDtoFromPageItems.apply(itemsToAdd);
        editorPage.onPageBuilder()._do().add().and().configure().items(sidebarItemsToAdd);
        Allure.addAttachment("Added items", "image/png", new ByteArrayInputStream(editorPage.takeScreenshot()), "png");
    }

    @When("^get editor properties for the '(.*)' item from the section '(.*)'$")
    public void getItemProperties(String component, String section) {
        EditorPage editorPage = storage.getValue(EDITOR, EditorPage.class);
        EditorComponentProperty editorComponentProperties = editorPage.onPageBuilder()._do().getComponent(section, component)
                .get()
                .editorItemProperties();
        storage.addValue(StorageKey.COMPONENT_PROPERTIES, editorComponentProperties);
    }

    @When("clear the layout")
    public void clearTheLayout() {
        EditorPage editorPage = storage.getValue(EDITOR, EditorPage.class);
        EditorSaveMenu editorSaveMenu = editorPage.onBottomPanel().openSaveMenu();
        editorSaveMenu.clearLayout();
        editorSaveMenu.switchToDraft();
    }

    @When("save draft page")
    public void saveDraftPage() {
        EditorPage editorPage = storage.getValue(EDITOR, EditorPage.class);
        editorPage.onBottomPanel().saveDraft();
    }

    @When("publish the page")
    public void publishThePage() {
        Page editorPage = storage.getValue(EDITOR_PAGE, Page.class);
        EditorBottomPanel editorBottomPanel = storage.getValue(EDITOR, EditorPage.class).onBottomPanel();
        editorBottomPanel.openSaveMenu().publishPage();
        Page page = editorPage.waitForPopup(editorBottomPanel::preview);
        page.waitForLoadState();
        storage.addValue(StorageKey.PUBLISH_PAGE, page);
    }
}
