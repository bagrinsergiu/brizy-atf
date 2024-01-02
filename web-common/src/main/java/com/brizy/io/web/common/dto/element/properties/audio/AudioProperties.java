package com.brizy.io.web.common.dto.element.properties.audio;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.audio.audio.Audio;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthHeightEffectsAndStylingProperties;
import com.brizy.io.web.common.dto.element.properties.text.colors.Colors;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AudioProperties implements Property {

    Colors colors;
    Alignments align;
    Audio audio;
    SettingsWithWidthHeightEffectsAndStylingProperties settings;

}
