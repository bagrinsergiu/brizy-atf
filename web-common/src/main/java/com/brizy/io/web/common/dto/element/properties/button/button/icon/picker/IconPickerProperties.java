package com.brizy.io.web.common.dto.element.properties.button.button.icon.picker;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IconPickerProperties {

    String type;
    String category;
    String value;

}
