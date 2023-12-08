package com.brizy.io.web.test.transformer;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.type.Content;
import com.brizy.io.web.common.dto.element.type.ItemType;
import com.brizy.io.web.common.dto.element.type.ItemTypeWithContent;
import com.brizy.io.web.test.model.page.Item;
import io.vavr.control.Try;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@UtilityClass
public class ItemTransformer {

    public BiFunction<List<Item>, List<ItemType>, List<Item>> enrichItemsWithProperties = (itemsList, propertiesList) -> itemsList.stream()
            .map(item -> item.toBuilder()
                    .properties(getPropertiesByItemName(propertiesList, item.getName()))
                    .content(getContentByItemName(propertiesList, item.getName()))
                    .build())
            .collect(Collectors.toList());

    private Property getPropertiesByItemName(List<ItemType> propertyList, String itemName) {
        return propertyList.stream()
                .filter(propertyType -> propertyType.getItemName().equals(itemName))
                .map(ItemType::getProperties)
                .map(property -> ((Property) property))
                .findFirst()
                .orElse(null);
    }

    private List<Content> getContentByItemName(List<ItemType> propertyList, String itemName) {
        return propertyList.stream()
                .filter(propertyType -> propertyType.getItemName().equals(itemName))
                .map(item -> Try.of(() -> (ItemTypeWithContent) item).getOrElse(() -> null))
                .filter(Objects::nonNull)
                .map(ItemTypeWithContent::getContent)
                .filter(Objects::nonNull)
                .flatMap(Arrays::stream)
                .toList();
    }

}
