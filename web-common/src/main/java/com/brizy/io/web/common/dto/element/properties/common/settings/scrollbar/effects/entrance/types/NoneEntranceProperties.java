package com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.effects.entrance.types;

import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.effects.entrance.EntranceProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NoneEntranceProperties implements EntranceProperties {

    String value;

}
