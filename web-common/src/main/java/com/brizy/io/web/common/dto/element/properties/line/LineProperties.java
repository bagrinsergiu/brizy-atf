package com.brizy.io.web.common.dto.element.properties.line;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthEffectsAndStylingProperties;
import com.brizy.io.web.common.dto.element.properties.image.colors.ImageColors;
import com.brizy.io.web.common.dto.element.properties.line.pop_up.LinePopUpProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SuperBuilder(toBuilder = true)
@Data
public class LineProperties implements Property {

    LinePopUpProperties line;
    List<ImageColors> colors;
    Alignments align;
    SettingsWithWidthEffectsAndStylingProperties settings;

}
