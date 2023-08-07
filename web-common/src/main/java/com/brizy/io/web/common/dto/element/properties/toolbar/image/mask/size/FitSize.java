package com.brizy.io.web.common.dto.element.properties.toolbar.image.mask.size;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FitSize implements Size {

    String position;
    String repeat;

}
