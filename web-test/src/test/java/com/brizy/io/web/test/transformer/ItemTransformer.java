package com.brizy.io.web.test.transformer;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.type.ItemType;
import com.brizy.io.web.test.model.page.Item;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

@UtilityClass
public class ItemTransformer {

    public BiFunction<List<Item>, List<ItemType>, List<Item>> enrichItemsWithProperties = (itemsList, propertiesList) -> itemsList.stream()
            .map(item -> item.toBuilder().properties(getPropertiesByItemName(propertiesList, item.getName())).build())
            .collect(Collectors.toList());

    private Property getPropertiesByItemName(List<ItemType> propertyList, String itemName) {
        return propertyList.stream()
                .filter(propertyType -> propertyType.getItemName().equals(itemName))
                .map(ItemType::getProperties)
                .map(property -> ((Property) property))
                .findFirst()
                .orElse(null);
    }

}
