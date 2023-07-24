package com.brizy.io.web.common.dto.element.properties.text;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.toolbar.common.settings.Settings;
import com.brizy.io.web.common.dto.element.properties.toolbar.text.typography.Typography;
import com.brizy.io.web.common.dto.element.properties.toolbar.text.colors.Colors;
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

    @Override
    public Colors getColors() {
        return null;
    }

    @Override
    public Settings getSettings() {
        return null;
    }

}
