package com.brizy.io.web.common.dto.element.properties.image.defaults;

import com.brizy.io.web.common.dto.element.properties.DefaultProperty;
import com.brizy.io.web.common.dto.element.properties.image.image.image.Image;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.Mask;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ImageDefaultProperties implements DefaultProperty {

    Image image;
    Mask mask;

}
