package com.brizy.io.web.common.dto.element.properties.button.settings.effects.hover.types;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AnyHoverParametersProperties {

    String style;
    String direction;
    Double duration;
    Boolean infiniteAnimation;

}
