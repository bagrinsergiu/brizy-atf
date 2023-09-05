package com.brizy.io.web.common.dto.element.properties.common.settings.settings;

import com.brizy.io.web.common.dto.element.properties.common.settings.settings.effects.EffectsProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.settings.styling.StylingProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SettingsProperties {

    StylingProperties styling;
    EffectsProperties effects;

}
