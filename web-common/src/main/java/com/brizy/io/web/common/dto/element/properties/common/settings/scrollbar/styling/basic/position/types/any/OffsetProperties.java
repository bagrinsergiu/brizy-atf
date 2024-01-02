package com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.position.types.any;

import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class OffsetProperties {

    String direction;
    InputWithUnitsProperties offset;

}
