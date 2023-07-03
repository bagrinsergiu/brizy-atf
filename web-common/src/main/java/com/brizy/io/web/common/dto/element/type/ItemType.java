package com.brizy.io.web.common.dto.element.type;

import com.brizy.io.web.common.dto.element.properties.DefaultProperty;
import com.brizy.io.web.common.dto.element.properties.Property;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "elementType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Map.class, name = "map"),
        @JsonSubTypes.Type(value = Button.class, name = "button"),
        @JsonSubTypes.Type(value = Counter.class, name = "counter")
})
public interface ItemType {

    String getItemName();

    <T extends Property> T getProperties();

    <T extends DefaultProperty> T getDefaultProperties();

}
