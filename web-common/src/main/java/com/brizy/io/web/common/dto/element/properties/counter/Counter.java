package com.brizy.io.web.common.dto.element.properties.counter;

import com.brizy.io.web.common.dto.element.properties.counter.defaults.CounterAdvancedProperties;
import com.brizy.io.web.common.dto.element.properties.counter.defaults.CounterTabProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Counter {

    CounterTabProperties counter;
    CounterAdvancedProperties counterAdvancedProperties;

}
