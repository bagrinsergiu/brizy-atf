package com.brizy.io.web.common.dto.element.properties.button.button.button.corner;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CustomCorner implements CornerProperties{

    CustomCornerValue corner;

}
