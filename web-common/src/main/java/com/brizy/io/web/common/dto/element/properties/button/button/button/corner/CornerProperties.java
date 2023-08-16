package com.brizy.io.web.common.dto.element.properties.button.button.button.corner;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ConcreteCorner.class, names = {"SQUARE", "ROUND"}),
        @JsonSubTypes.Type(value = CustomCorner.class, name = "CUSTOM"),
})
public interface CornerProperties {}
