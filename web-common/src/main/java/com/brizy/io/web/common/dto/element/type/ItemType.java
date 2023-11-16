package com.brizy.io.web.common.dto.element.type;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "elementType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Button.class, name = "button"),
        @JsonSubTypes.Type(value = Counter.class, name = "counter"),
        @JsonSubTypes.Type(value = Icon.class, name = "icon"),
        @JsonSubTypes.Type(value = Image.class, name = "image"),
        @JsonSubTypes.Type(value = Map.class, name = "map"),
        @JsonSubTypes.Type(value = Spacer.class, name = "spacer"),
        @JsonSubTypes.Type(value = Text.class, name = "text"),
        @JsonSubTypes.Type(value = Form.class, name = "form"),
        @JsonSubTypes.Type(value = Audio.class, name = "audio"),
        @JsonSubTypes.Type(value = Video.class, name = "video")
})
public interface ItemType {

    String getScenarioName();

    String getItemName();

    <T extends Property> T getProperties();

}
