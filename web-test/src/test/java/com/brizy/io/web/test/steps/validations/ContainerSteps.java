package com.brizy.io.web.test.steps.validations;

import com.brizy.io.web.common.dto.element.type.ItemType;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.page.editor.EditorPage;
import com.brizy.io.web.interactions.page.editor.container.components.Component;
import com.brizy.io.web.test.storage.Storage;
import io.cucumber.java.en.Then;
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


    @Then("section '{}' contains '{}' items")
    public void sectionSectionNameContainsItems(String sectionName, Integer expectedNumberOfItems) {
        EditorPage editorPage = storage.getValue(EDITOR, EditorPage.class);
        Assertions.assertThat(editorPage.onPageBuilder()._do().getComponents(sectionName))
                .size()
                .describedAs("Expecting to have <%d> items on section <%s>", expectedNumberOfItems, sectionName)
                .isEqualTo(expectedNumberOfItems + 1);
    }

}
