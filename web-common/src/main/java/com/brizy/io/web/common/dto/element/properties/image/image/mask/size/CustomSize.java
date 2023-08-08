package com.brizy.io.web.common.dto.element.properties.image.image.mask.size;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CustomSize implements Size {

    ToFill fill;
    String position;
    String repeat;

}
