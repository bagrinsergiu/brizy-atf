package com.brizy.io.web.common.dto.element.properties.image.image.shadow;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Inset.class, name = "inset"),
        @JsonSubTypes.Type(value = Outset.class, name = "outset"),
        @JsonSubTypes.Type(value = None.class, name = "none")
})
public interface CanHaveShadow {

    String getColor();

    ShadowProperties getProperties();

}
