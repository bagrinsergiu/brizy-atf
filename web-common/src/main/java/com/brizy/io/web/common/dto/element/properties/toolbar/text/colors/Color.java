package com.brizy.io.web.common.dto.element.properties.toolbar.text.colors;

import com.brizy.io.web.common.dto.element.properties.toolbar.text.colors.enums.ColorType;
import com.brizy.io.web.common.dto.element.type.Button;
import com.brizy.io.web.common.dto.element.type.Counter;
import com.brizy.io.web.common.dto.element.type.Map;
import com.brizy.io.web.common.dto.element.type.Text;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SolidColor.class, name = "solid"),
        @JsonSubTypes.Type(value = Gradient.class, name = "gradient")
})
public interface Color {

    String getColor();

}
