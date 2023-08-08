package com.brizy.io.web.common.dto.element.properties.text.colors;

import com.brizy.io.web.common.dto.element.properties.image.colors.gradient.Color;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Colors implements com.brizy.io.web.common.dto.element.properties.common.Colors {

    Color color;

}
