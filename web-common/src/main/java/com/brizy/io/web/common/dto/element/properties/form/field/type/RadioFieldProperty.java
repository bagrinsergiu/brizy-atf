package com.brizy.io.web.common.dto.element.properties.form.field.type;

import com.brizy.io.web.common.dto.element.properties.form.field.configuration.type.FieldWithOptionsAndColumnsConfigurationProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RadioFieldProperty extends AbstractFieldProperty {

    FieldWithOptionsAndColumnsConfigurationProperty configuration;

    public RadioFieldProperty(Integer spacing, String type, String placeholder, boolean required, FieldWithOptionsAndColumnsConfigurationProperty configuration) {
        super(type, placeholder, required, spacing);
        this.configuration = configuration;
    }

}
