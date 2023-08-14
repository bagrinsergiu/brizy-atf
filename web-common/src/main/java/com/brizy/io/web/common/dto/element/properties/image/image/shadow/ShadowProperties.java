package com.brizy.io.web.common.dto.element.properties.image.image.shadow;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ShadowProperties {

    Integer blurRadius;
    Integer verticalOffset;
    Integer horizontalOffset;
    Integer spreadRadius;

}
