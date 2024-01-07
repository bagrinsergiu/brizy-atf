package com.brizy.io.web.common.dto.element.properties.progress_bar;

import com.brizy.io.web.common.dto.element.properties.Property;
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
public class ProgressBarProperties implements Property {

    Colors colors;
    Alignments align;
    com.brizy.io.web.common.dto.element.properties.progress_bar.progress_bar.ProgressBarProperties progress;
    SettingsWithWidthHeightEffectsAndStylingProperties settings;

}
