package com.brizy.io.web.common.dto.element.properties.image.colors.gradient;

import com.brizy.io.web.common.dto.element.properties.common.enums.GradientType;
import com.brizy.io.web.common.dto.element.properties.image.colors.overlay.Overlay;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Gradient implements Color, Overlay {

    @Getter
    String color;
    GradientType gradientType;
    Integer angle;

}
