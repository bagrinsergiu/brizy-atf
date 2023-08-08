package com.brizy.io.web.common.dto.element.properties.toolbar.image;

import com.brizy.io.web.common.dto.element.properties.toolbar.image.mask.Mask;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Image {

    com.brizy.io.web.common.dto.element.properties.toolbar.image.image.Image image;
    Mask mask;

}
