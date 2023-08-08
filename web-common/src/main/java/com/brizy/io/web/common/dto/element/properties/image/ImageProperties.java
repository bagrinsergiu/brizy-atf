package com.brizy.io.web.common.dto.element.properties.image;

import com.brizy.io.web.common.dto.element.properties.AbstractProperty;
import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.toolbar.image.Image;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
public class ImageProperties extends AbstractProperty implements Property {

    Image image;

}
