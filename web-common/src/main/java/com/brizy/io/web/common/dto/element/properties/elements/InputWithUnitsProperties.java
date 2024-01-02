package com.brizy.io.web.common.dto.element.properties.elements;

import com.brizy.io.web.common.dto.element.properties.common.settings.UnitType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class InputWithUnitsProperties {

    UnitType unit;
    Number value;

}
