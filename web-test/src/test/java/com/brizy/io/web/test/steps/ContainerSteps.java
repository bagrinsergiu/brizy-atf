package com.brizy.io.web.test.steps;

import com.brizy.io.web.interactions.dto.editor.sidebar.SidebarItemDto;
import com.brizy.io.web.interactions.page.EditorPage;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.model.page.Item;
import com.brizy.io.web.test.model.page.ItemProperty;
import com.brizy.io.web.test.storage.Storage;
import com.brizy.io.web.test.transformer.MapperTransformerUtil;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.vavr.NotImplementedError;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ContainerSteps {

    ModelMapper modelMapper;
    Storage storage;

    @Autowired
    public ContainerSteps(ModelMapper modelMapper, Storage storage) {
        this.modelMapper = modelMapper;
        this.storage = storage;
    }

    @When("prepare the following items to be added to the page:")
    public void prepareTheFollowingItemsToBeAddedToThePage(List<Item> items) {
        storage.addValue(StorageKey.ITEMS_TO_BE_ADDED_TO_THE_PAGE, items);
    }

    @When("prepare the following properties for the items to be added to the page:")
    public void prepareTheFollowingPropertiesForTheItemsToBeAddedToThePage(List<ItemProperty> properties) {
        throw new NotImplementedError();
    }

    @When("add the items to the page")
    public void addTheItemsToThePage() {
        EditorPage editorPage = storage.getValue(StorageKey.EDITOR_PAGE, EditorPage.class);
        List<Item> itemsToAdd = storage.getListValue(StorageKey.ITEMS_TO_BE_ADDED_TO_THE_PAGE, Item.class);
        List<SidebarItemDto> sidebarItemsToAdd = MapperTransformerUtil.getSidebarItemsDtoFromPageItems.apply(itemsToAdd);
        editorPage.editPage().add(sidebarItemsToAdd);
        Allure.addAttachment("Added items", "image/png", new ByteArrayInputStream(editorPage.takeScreenshot()), "png");
    }

}
