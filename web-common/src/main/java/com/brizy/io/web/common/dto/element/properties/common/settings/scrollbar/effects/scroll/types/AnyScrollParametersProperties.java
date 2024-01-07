package com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.effects.scroll.types;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AnyScrollParametersProperties {

    String direction;
    String x;
    String y;
    Integer speed;
    Integer start;
    Integer stop;

}
