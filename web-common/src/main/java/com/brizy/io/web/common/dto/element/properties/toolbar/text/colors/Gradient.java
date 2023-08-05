package com.brizy.io.web.common.dto.element.properties.toolbar.text.colors;

import com.brizy.io.web.common.dto.element.properties.toolbar.text.colors.enums.GradientType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Gradient implements Color {

    @Getter
    String color;
    GradientType gradientType;
    Integer angle;

}
