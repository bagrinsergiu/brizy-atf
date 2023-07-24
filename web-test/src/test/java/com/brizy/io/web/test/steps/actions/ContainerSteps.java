package com.brizy.io.web.test.steps.actions;

import com.brizy.io.web.common.dto.element.type.ItemType;
import com.brizy.io.web.interactions.dto.editor.container.right_click_context_menu.ContextMenuItemDto;
import com.brizy.io.web.interactions.page.editor.bottom_panel.EditorBottomPanel;
import com.brizy.io.web.interactions.page.editor.bottom_panel.EditorSaveMenu;
import com.brizy.io.web.interactions.dto.editor.container.properties.CssProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.dto.editor.sidebar.SidebarItemDto;
import com.brizy.io.web.interactions.page.editor.EditorPage;
import com.brizy.io.web.test.data.service.TestDataFileService;
import com.brizy.io.web.interactions.enums.ContextMenuActions;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.exception.InvalidScenarioNameException;
import com.brizy.io.web.test.exception.ItemNotFoundException;
import com.brizy.io.web.test.model.page.FileName;
import com.brizy.io.web.test.model.page.Item;
import com.brizy.io.web.test.storage.Storage;
import com.brizy.io.web.test.transformer.ItemTransformer;
import com.brizy.io.web.test.transformer.MapperTransformerUtil;
import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.util.List;

import static com.brizy.io.web.test.enums.StorageKey.*;
import static java.util.Collections.singletonList;

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
        List<ItemType> itemProperties = singletonList(testDataFileService.getItemProperties(properties.getFullName(), ItemType[].class).stream()
                .filter(property -> property.getScenarioName().equals(currentScenario.getName()))
                .findFirst()
                .orElseThrow(() -> new InvalidScenarioNameException(String.format("Unable to find any scenario with name %s inside the file %s", currentScenario.getName(), properties))));
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
        editorPage.onPageBuilder()._do().add().items(sidebarItemsToAdd);
        Allure.addAttachment("Added items", "image/png", new ByteArrayInputStream(editorPage.takeScreenshot()), "png");
    }

    @When("configure the item(s) added to the page")
    public void configureTheItemsToTheSection() {
        EditorPage editorPage = storage.getValue(EDITOR, EditorPage.class);
        List<Item> itemsToAdd = storage.getListValue(ITEMS_TO_BE_ADDED_TO_THE_PAGE, Item.class);
        List<SidebarItemDto> sidebarItemsToAdd = MapperTransformerUtil.getSidebarItemsDtoFromPageItems.apply(itemsToAdd);
        editorPage.onPageBuilder()._do().configure().items(sidebarItemsToAdd);
    }

    @When("^get editor properties for the '(.*)' item from the section '(.*)'$")
    public void getItemProperties(String component, String section) {
        EditorPage editorPage = storage.getValue(EDITOR, EditorPage.class);
        EditorComponentProperty editorComponentProperties = editorPage.onPageBuilder()._do().findComponent(section, component)
                .get()
                .editorItemProperties();
        storage.addValue(StorageKey.COMPONENT_PROPERTIES, editorComponentProperties);
    }

    @When("^get css properties for the '(.*)' editor item from the section '(.*)'$")
    public void getCssItemProperties(String component, String section) {
        EditorPage editorPage = storage.getValue(EDITOR, EditorPage.class);
        CssProperties cssProperties = editorPage.onPageBuilder()._do().findComponent(section, component)
                .get()
                .cssItemProperties();
        storage.addValue(StorageKey.CSS_EDITOR_COMPONENT_PROPERTIES, cssProperties);
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

    @When("{contextMenuAction} the following item '{}'")
    public void doActionOnItem(ContextMenuActions contextMenuAction, String itemName) {
        String sectionName = storage.getListValue(ITEMS_TO_BE_ADDED_TO_THE_PAGE, Item.class).stream()
                .filter(el -> el.getName().equals(itemName))
                .findFirst()
                .map(Item::getSectionName)
                .orElseThrow(() -> new ItemNotFoundException(String.format("Item with name %s, not found on page", itemName)));
        EditorPage editorPage = storage.getValue(EDITOR, EditorPage.class);
        editorPage.onPageBuilder()._do().findComponent(sectionName, itemName).onContextMenu().execute(contextMenuAction);
    }

    @When("get context menu items for '{}'")
    public void doGetItems(String itemName) {
        String sectionName = storage.getListValue(ITEMS_TO_BE_ADDED_TO_THE_PAGE, Item.class).stream()
                .filter(el -> el.getName().equals(itemName))
                .findFirst()
                .map(Item::getSectionName)
                .orElseThrow(() -> new ItemNotFoundException(String.format("Item with name %s, not found on page", itemName)));
        EditorPage editorPage = storage.getValue(EDITOR, EditorPage.class);
        List<ContextMenuItemDto> actions = editorPage.onPageBuilder()._do().findComponent(sectionName, itemName).onContextMenu().getActions();
        storage.addValue(StorageKey.MENU_ITEMS, actions);
    }

}
