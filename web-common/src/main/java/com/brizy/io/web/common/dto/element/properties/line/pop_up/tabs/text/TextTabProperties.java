package com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.text;

import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.common.LineAlign;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TextTabProperties {

    LineAlign align;
    InputWithUnitsProperties spacing;

}
