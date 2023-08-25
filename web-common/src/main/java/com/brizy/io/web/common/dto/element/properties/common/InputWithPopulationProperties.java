package com.brizy.io.web.common.dto.element.properties.common;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class InputWithPopulationProperties {

    String value;
    PopulationProperties population;

}
