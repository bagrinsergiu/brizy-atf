package com.brizy.io.web.common.dto.element.properties.form.field.configuration.type;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FieldWithOptionsAndColumnsConfigurationProperty extends FieldWithOptionsConfigurationProperty {

    String columns;

}
