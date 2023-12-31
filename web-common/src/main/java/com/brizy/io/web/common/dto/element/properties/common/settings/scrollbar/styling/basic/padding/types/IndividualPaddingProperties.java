package com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.padding.types;


import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.padding.PaddingProperties;
import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IndividualPaddingProperties implements PaddingProperties {

    String value;
    InputWithUnitsProperties top;
    InputWithUnitsProperties right;
    InputWithUnitsProperties left;
    InputWithUnitsProperties bottom;

}
