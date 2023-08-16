package com.brizy.io.web.common.dto.element.properties.counter;

import com.brizy.io.web.common.dto.element.properties.counter.enums.StypeType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Counter {

    StypeType style;

}
