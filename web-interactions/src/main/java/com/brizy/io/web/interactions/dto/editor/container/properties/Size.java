package com.brizy.io.web.interactions.dto.editor.container.properties;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Builder
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Size {

    Double value;
//    UnitType type;

}
