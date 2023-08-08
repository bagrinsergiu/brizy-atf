package com.brizy.io.web.common.dto.element.properties.image.image.mask.size;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = FitSize.class, name = "Fit"),
        @JsonSubTypes.Type(value = CustomSize.class, name = "Custom"),
        @JsonSubTypes.Type(value = FillSize.class, name = "Fill")
})
public interface Size {
}
