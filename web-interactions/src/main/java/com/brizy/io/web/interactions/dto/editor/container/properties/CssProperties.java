package com.brizy.io.web.interactions.dto.editor.container.properties;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CssProperties {

    Colors colors;
    Settings settings;

}
