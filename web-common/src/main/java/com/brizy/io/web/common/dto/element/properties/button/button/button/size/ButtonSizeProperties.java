package com.brizy.io.web.common.dto.element.properties.button.button.button.size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ConcreteSize.class, names = {"SMALL", "MEDIUM", "LARGE"}),
        @JsonSubTypes.Type(value = CustomSize.class, name = "CUSTOM"),
})
public interface ButtonSizeProperties {}
