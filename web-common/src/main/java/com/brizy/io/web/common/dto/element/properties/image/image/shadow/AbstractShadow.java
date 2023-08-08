package com.brizy.io.web.common.dto.element.properties.image.image.shadow;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public abstract class AbstractShadow implements CanHaveShadow {

    String color;
    @Getter
    ShadowProperties properties;

}
