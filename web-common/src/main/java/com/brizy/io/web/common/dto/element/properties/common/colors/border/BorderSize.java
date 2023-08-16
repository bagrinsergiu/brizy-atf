package com.brizy.io.web.common.dto.element.properties.common.colors.border;

import com.brizy.io.web.common.dto.element.properties.button.button.icon.size.ConcreteSize;
import com.brizy.io.web.common.dto.element.properties.button.button.icon.size.CustomSize;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FixBorder.class, name= "fix"),
        @JsonSubTypes.Type(value = CustomBorder.class, name = "custom"),
})
public interface BorderSize {
}
