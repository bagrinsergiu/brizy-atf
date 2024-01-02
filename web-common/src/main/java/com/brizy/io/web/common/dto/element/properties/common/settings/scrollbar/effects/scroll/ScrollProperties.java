package com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.effects.scroll;

import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.effects.scroll.types.AnyScrollProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.effects.scroll.types.NoneScrollProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NoneScrollProperties.class, name = "none"),
        @JsonSubTypes.Type(value = AnyScrollProperties.class, name = "other"),
})
public interface ScrollProperties {

    String getValue();

}
