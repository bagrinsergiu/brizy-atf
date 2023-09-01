package com.brizy.io.web.common.dto.element.properties.counter.defaults;

import com.brizy.io.web.common.dto.element.properties.common.InputWithPopulationProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CounterAdvancedProperties {

    InputWithPopulationProperties prefix;
    InputWithPopulationProperties suffix;
    InputWithPopulationProperties separator;

}
