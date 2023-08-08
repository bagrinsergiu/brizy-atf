package com.brizy.io.web.common.dto.element.properties.image;

import com.brizy.io.web.common.dto.element.properties.AbstractProperty;
import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.toolbar.image.Image;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
public class ImageProperties extends AbstractProperty implements Property {

    Image image;

}
