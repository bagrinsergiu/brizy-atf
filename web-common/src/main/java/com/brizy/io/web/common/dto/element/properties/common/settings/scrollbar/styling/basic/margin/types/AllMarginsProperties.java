package com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.margin.types;

import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.margin.MarginProperties;
import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AllMarginsProperties implements MarginProperties {

    String value;
    InputWithUnitsProperties size;

}
