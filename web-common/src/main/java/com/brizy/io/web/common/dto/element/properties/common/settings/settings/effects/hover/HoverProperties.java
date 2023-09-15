package com.brizy.io.web.common.dto.element.properties.common.settings.settings.effects.hover;

import com.brizy.io.web.common.dto.element.properties.common.settings.settings.effects.hover.types.AnyHoverProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.settings.effects.hover.types.NoneHoverProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NoneHoverProperties.class, name = "none"),
        @JsonSubTypes.Type(value = AnyHoverProperties.class, name = "other"),
})
public interface HoverProperties {

    String getValue();

}
