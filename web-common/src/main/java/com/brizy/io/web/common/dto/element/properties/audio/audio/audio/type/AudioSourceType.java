package com.brizy.io.web.common.dto.element.properties.audio.audio.audio.type;

import com.brizy.io.web.common.dto.element.properties.button.button.icon.size.ConcreteSize;
import com.brizy.io.web.common.dto.element.properties.button.button.icon.size.CustomSize;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ConcreteSize.class, name = "SoundCloud"),
        @JsonSubTypes.Type(value = CustomSize.class, name = "Custom"),
})
public interface AudioSourceType {
}
