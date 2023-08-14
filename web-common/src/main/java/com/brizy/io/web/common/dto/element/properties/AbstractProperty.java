package com.brizy.io.web.common.dto.element.properties;

import com.brizy.io.web.common.dto.element.properties.common.colors.Colors;
import com.brizy.io.web.common.dto.element.properties.common.settings.Settings;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
@Data
public abstract class AbstractProperty {

    Colors colors;
    Settings settings;

}