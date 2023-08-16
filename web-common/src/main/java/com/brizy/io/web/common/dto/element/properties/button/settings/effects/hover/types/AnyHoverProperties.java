package com.brizy.io.web.common.dto.element.properties.button.settings.effects.hover.types;

import com.brizy.io.web.common.dto.element.properties.button.settings.effects.entrance.EntranceProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.effects.hover.HoverProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AnyHoverProperties implements HoverProperties {

    String value;
    AnyHoverParametersProperties parameters;

}
