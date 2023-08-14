package com.brizy.io.web.common.dto.element.properties.image.image.mask.shape;

import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AnyPredefinedMask implements Shape {

    String shape;
    Size size;

}
