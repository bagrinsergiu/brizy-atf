package com.brizy.io.web.common.dto.element.properties.counter;

import com.brizy.io.web.common.dto.element.properties.AbstractProperty;
import com.brizy.io.web.common.dto.element.properties.Property;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CounterProperties extends AbstractProperty implements Property {

    Counter counter;

}
