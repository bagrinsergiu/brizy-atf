package com.brizy.io.web.common.dto.element.properties.common.settings;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Size {

    Integer value;
    UnitType unit;

}
