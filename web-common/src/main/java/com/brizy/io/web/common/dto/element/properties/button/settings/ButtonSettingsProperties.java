package com.brizy.io.web.common.dto.element.properties.button.settings;

import com.brizy.io.web.common.dto.element.properties.button.settings.effects.EffectsProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.styling.StylingProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ButtonSettingsProperties {

    StylingProperties styling;
    EffectsProperties effects;

}
