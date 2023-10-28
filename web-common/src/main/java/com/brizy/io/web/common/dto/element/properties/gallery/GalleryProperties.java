package com.brizy.io.web.common.dto.element.properties.gallery;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.button.link.LinkProperties;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.settings.settings.SettingsProperties;
import com.brizy.io.web.common.dto.element.properties.image.ImageProperties;
import com.brizy.io.web.common.dto.element.properties.image.colors.ImageColors;
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
public class GalleryProperties implements Property {


    ImageProperties image;
    List<ImageColors> colors;
    LinkProperties link;
    Alignments align;

}
