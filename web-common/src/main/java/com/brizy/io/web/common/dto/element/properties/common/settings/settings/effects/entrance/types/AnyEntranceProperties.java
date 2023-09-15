package com.brizy.io.web.common.dto.element.properties.common.settings.settings.effects.entrance.types;

import com.brizy.io.web.common.dto.element.properties.common.settings.settings.effects.entrance.EntranceProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AnyEntranceProperties implements EntranceProperties {

    String value;
    AnyEntranceParametersProperties parameters;

}
