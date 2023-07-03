package com.brizy.io.web.test.steps.validations;

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
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
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
        System.out.println(actualProperties);
    }
}
