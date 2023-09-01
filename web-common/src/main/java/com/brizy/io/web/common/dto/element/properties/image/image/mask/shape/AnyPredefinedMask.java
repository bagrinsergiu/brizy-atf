package com.brizy.io.web.common.dto.element.properties.image.image.mask.shape;

import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AnyPredefinedMask implements Shape {

    String shape;
    Size size;

}
