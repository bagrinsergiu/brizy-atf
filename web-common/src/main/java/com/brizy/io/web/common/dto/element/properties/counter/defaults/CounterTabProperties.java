package com.brizy.io.web.common.dto.element.properties.counter.defaults;

import com.brizy.io.web.common.dto.element.properties.common.InputWithPopulationProperties;
import com.brizy.io.web.common.dto.element.properties.counter.enums.CounterType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CounterTabProperties {

    CounterType style;
    InputWithPopulationProperties start;
    InputWithPopulationProperties end;
    Double duration;

}
