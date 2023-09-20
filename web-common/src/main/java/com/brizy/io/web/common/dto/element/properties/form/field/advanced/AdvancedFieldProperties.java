package com.brizy.io.web.common.dto.element.properties.form.field.advanced;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
public class AdvancedFieldProperties {

    boolean label;
    boolean placeholder;

}
