package com.brizy.io.web.common.dto.element.properties.common.settings.settings.styling.basic.position.types;

import com.brizy.io.web.common.dto.element.properties.common.settings.settings.styling.basic.position.PositionProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.settings.styling.basic.position.types.any.OffsetProperties;
import com.brizy.io.web.common.dto.element.properties.common.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AbsoluteOrFixedPositionProperties implements PositionProperties {

    String value;
    InputWithUnitsProperties width;
    OffsetProperties horizontalOffset;
    OffsetProperties verticalOffset;

}
