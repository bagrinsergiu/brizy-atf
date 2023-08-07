package com.brizy.io.web.common.dto.element.properties.toolbar.image.mask.shape;

import com.brizy.io.web.common.dto.element.properties.toolbar.image.mask.size.Size;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AnyPredefinedMask implements Shape {

    String shape;
    Size size;

}
