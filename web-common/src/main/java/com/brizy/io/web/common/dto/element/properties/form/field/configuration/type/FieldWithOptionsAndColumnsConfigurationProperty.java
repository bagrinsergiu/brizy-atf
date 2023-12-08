package com.brizy.io.web.common.dto.element.properties.form.field.configuration.type;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FieldWithOptionsAndColumnsConfigurationProperty extends FieldWithOptionsConfigurationProperty {

    String columns;

}
