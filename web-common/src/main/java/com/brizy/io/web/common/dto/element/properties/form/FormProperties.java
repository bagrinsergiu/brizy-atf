package com.brizy.io.web.common.dto.element.properties.form;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.common.typography.Typography;
import com.brizy.io.web.common.dto.element.properties.form.field.FieldProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
public class FormProperties implements Property {

    Typography typography;
    FieldProperties field;

}
