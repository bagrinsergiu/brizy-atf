package com.brizy.io.web.common.dto.element.properties.common.settings.settings.styling.basic.position;


import com.brizy.io.web.common.dto.element.properties.common.settings.settings.styling.basic.position.types.AbsoluteOrFixedPositionProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.settings.styling.basic.position.types.NonePositionProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NonePositionProperties.class, name = "none"),
        @JsonSubTypes.Type(value = AbsoluteOrFixedPositionProperties.class, names = {"absolute", "fixed"}),
})
public interface PositionProperties {

    String getValue();

}
