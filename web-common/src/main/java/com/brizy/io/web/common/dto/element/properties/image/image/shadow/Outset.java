package com.brizy.io.web.common.dto.element.properties.image.image.shadow;

import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Outset extends AbstractShadow {
}
