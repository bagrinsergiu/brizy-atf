package com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.position.types;

import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.position.PositionProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NonePositionProperties implements PositionProperties {

    String value;

}
