package com.brizy.io.web.common.dto.element.properties.button.settings.effects.scroll.types;

import com.brizy.io.web.common.dto.element.properties.button.settings.effects.entrance.EntranceProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.effects.scroll.ScrollProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AnyScrollProperties implements ScrollProperties {

    String value;
    AnyScrollParametersProperties parameters;

}
