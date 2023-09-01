package com.brizy.io.web.common.dto.element.properties.image.image;

import com.brizy.io.web.common.dto.element.properties.image.image.mask.Mask;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Image {

    com.brizy.io.web.common.dto.element.properties.image.image.image.Image image;
    Mask mask;

}
