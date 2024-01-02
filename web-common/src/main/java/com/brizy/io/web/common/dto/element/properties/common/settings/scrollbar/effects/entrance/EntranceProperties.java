package com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.effects.entrance;

import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.effects.entrance.types.AnyEntranceProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.effects.entrance.types.NoneEntranceProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NoneEntranceProperties.class, name = "none"),
        @JsonSubTypes.Type(value = AnyEntranceProperties.class, name = "other"),
})
public interface EntranceProperties {

    String getValue();

}
