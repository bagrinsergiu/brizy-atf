package com.brizy.io.web.common.dto.element.properties.countdown;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthEffectsAndStylingProperties;
import com.brizy.io.web.common.dto.element.properties.countdown.countdown.Countdown;
import com.brizy.io.web.common.dto.element.properties.text.colors.Colors;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CountdownProperties implements Property {

    Colors colors;
    Alignments align;
    Countdown countdown;
    SettingsWithWidthEffectsAndStylingProperties settings;

}
