package com.brizy.io.web.common.dto.element.properties.countdown.countdown.advanced;

import lombok.*;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CountdownAdvancedProperties {

    Boolean days;
    Boolean hours;
    Boolean minutes;
    Boolean seconds;

}
