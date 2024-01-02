package com.brizy.io.web.common.dto.element.properties.image;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthHeightEffectsAndStylingProperties;
import com.brizy.io.web.common.dto.element.properties.image.colors.ImageColors;
import com.brizy.io.web.common.dto.element.properties.image.image.Image;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
public class ImageProperties implements Property {

    Image image;
    List<ImageColors> colors;
    SettingsWithWidthHeightEffectsAndStylingProperties settings;
    Alignments align;

}
