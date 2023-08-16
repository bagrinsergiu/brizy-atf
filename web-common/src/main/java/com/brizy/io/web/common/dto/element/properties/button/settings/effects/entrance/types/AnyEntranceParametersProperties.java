package com.brizy.io.web.common.dto.element.properties.button.settings.effects.entrance.types;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AnyEntranceParametersProperties {

    String direction;
    Boolean big;
    Double duration;
    Integer delay;
    Boolean infiniteAnimation;

}
