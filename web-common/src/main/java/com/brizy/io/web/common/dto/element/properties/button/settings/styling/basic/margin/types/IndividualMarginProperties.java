package com.brizy.io.web.common.dto.element.properties.button.settings.styling.basic.margin.types;


import com.brizy.io.web.common.dto.element.properties.button.settings.styling.basic.margin.MarginProperties;
import com.brizy.io.web.common.dto.element.properties.common.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IndividualMarginProperties implements MarginProperties {

    String value;
    InputWithUnitsProperties top;
    InputWithUnitsProperties right;
    InputWithUnitsProperties left;
    InputWithUnitsProperties bottom;

}
