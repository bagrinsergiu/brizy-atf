package com.brizy.io.web.common.dto.element.properties.text;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.text.colors.Colors;
import com.brizy.io.web.common.dto.element.properties.common.typography.Typography;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TextProperties implements Property {

    Colors colors;
    @Getter
    Typography typography;
    Boolean bold;
    Boolean italic;
    Boolean underline;
    Boolean strike;
    Boolean uppercase;

}
