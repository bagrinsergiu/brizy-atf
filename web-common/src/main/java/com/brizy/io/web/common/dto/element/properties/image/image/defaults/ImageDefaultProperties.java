package com.brizy.io.web.common.dto.element.properties.image.image.defaults;

import com.brizy.io.web.common.dto.element.properties.DefaultProperty;
import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.common.settings.Settings;
import com.brizy.io.web.common.dto.element.properties.image.colors.ImageColors;
import com.brizy.io.web.common.dto.element.properties.image.image.Image;
import com.brizy.io.web.common.dto.element.properties.image.image.align.Aligns;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
public class ImageDefaultProperties implements DefaultProperty {


}
