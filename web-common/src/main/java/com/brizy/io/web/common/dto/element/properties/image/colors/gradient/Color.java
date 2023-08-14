package com.brizy.io.web.common.dto.element.properties.image.colors.gradient;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Solid.class, name = "solid"),
        @JsonSubTypes.Type(value = None.class, name = "none"),
        @JsonSubTypes.Type(value = Gradient.class, name = "gradient")
})
public interface Color {

    String getColor();

}
