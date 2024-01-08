package com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.line;

import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LineTabProperties {

    LineStyles style;
    String type;
    InputWithUnitsProperties height;

}
