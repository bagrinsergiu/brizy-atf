package com.brizy.io.web.common.dto.element.properties.image.image.image;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Image {

    String image;
    Integer zoom;
    Boolean openInLightBox;

}
