package com.brizy.io.web.common.dto.element.properties.image.image.mask;

import com.brizy.io.web.common.dto.element.properties.image.image.mask.shape.Shape;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Mask {

    Shape shape;

}
