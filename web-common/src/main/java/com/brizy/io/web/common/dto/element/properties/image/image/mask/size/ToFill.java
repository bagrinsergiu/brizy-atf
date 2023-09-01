package com.brizy.io.web.common.dto.element.properties.image.image.mask.size;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ToFill {

    Integer value;
    FillUnits unit;

}
