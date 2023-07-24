package com.brizy.io.web.common.dto.element.properties.toolbar.text.colors;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SolidColor implements Color {

    @Getter
    String color;

}
