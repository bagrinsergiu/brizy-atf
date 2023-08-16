package com.brizy.io.web.common.dto.element.properties.button.button.icon.size;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ConcreteSize.class, names = {"SIZE_16", "SIZE_24", "SIZE_32"}),
        @JsonSubTypes.Type(value = CustomSize.class, name = "CUSTOM"),
})
public interface Size {}
