package com.brizy.io.web.common.dto.element.properties.map;

import com.brizy.io.web.common.dto.element.properties.AbstractProperty;
import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthHeightEffectsAndStylingProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class MapProperties extends AbstractProperty implements Property {

    SettingsWithWidthHeightEffectsAndStylingProperties settings;

}
