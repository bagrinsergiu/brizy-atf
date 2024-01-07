package com.brizy.io.web.common.dto.element.properties.icon;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.button.link.LinkProperties;
import com.brizy.io.web.common.dto.element.properties.common.align.Alignments;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.SettingsProperties;
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
public class IconProperties implements Property {

    com.brizy.io.web.common.dto.element.properties.icon.tabs.IconProperties icon;
    List<ImageColors> colors;
    LinkProperties link;
    Alignments align;
    SettingsProperties settings;

}
