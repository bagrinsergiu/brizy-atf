package com.brizy.io.web.test.steps;

import com.brizy.io.web.common.dto.element.type.ItemType;
import com.brizy.io.web.interactions.components.editor.bottom_panel.EditorBottomPanel;
import com.brizy.io.web.interactions.components.editor.bottom_panel.EditorSaveMenu;
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
        List<ItemType> propertyTypes = testDataFileService.getPropertyTypesFromTheFile(properties.getFullName(), ItemType[].class);
        List<Item> itemsToAdd = storage.getListValue(ITEMS_TO_BE_ADDED_TO_THE_PAGE, Item.class);
        List<Item> itemsWithProperties = ItemTransformer.enrichItemsWithProperties.apply(itemsToAdd, propertyTypes);
        storage.addValue(ITEMS_TO_BE_ADDED_TO_THE_PAGE, itemsWithProperties);
    }

    @When("add the items to the page")
    public void addTheItemsToTheSection() {
        EditorPage editorPage = storage.getValue(EDITOR, EditorPage.class);
        List<Item> itemsToAdd = storage.getListValue(ITEMS_TO_BE_ADDED_TO_THE_PAGE, Item.class);
        List<SidebarItemDto> sidebarItemsToAdd = MapperTransformerUtil.getSidebarItemsDtoFromPageItems.apply(itemsToAdd);
        editorPage.onPageBuilder()._do().add().and().configure().items(sidebarItemsToAdd);
        Allure.addAttachment("Added items", "image/png", new ByteArrayInputStream(editorPage.takeScreenshot()), "png");
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
