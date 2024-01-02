package com.brizy.io.web.common.dto.element.properties.common.settings.pop_up;

import com.brizy.io.web.common.dto.element.properties.common.settings.HasEffects;
import com.brizy.io.web.common.dto.element.properties.common.settings.HasHeight;
import com.brizy.io.web.common.dto.element.properties.common.settings.HasStyling;
import com.brizy.io.web.common.dto.element.properties.common.settings.HasWidth;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.effects.EffectsProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.StylingProperties;
import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SettingsWithWidthHeightEffectsAndStylingProperties implements HasWidth, HasEffects, HasStyling, HasHeight {

    InputWithUnitsProperties height;
    InputWithUnitsProperties width;
    EffectsProperties effects;
    StylingProperties styling;

}
