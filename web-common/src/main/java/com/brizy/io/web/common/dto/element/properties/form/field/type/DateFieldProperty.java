package com.brizy.io.web.common.dto.element.properties.form.field.type;

import com.brizy.io.web.common.dto.element.properties.form.field.configuration.type.DateFieldConfigurationProperty;
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
public class DateFieldProperty extends AbstractFieldProperty {

    boolean nativeHtml5;
    DateFieldConfigurationProperty configuration;

    public DateFieldProperty(Integer spacing, String type, String placeholder, boolean required, boolean nativeHtml5, DateFieldConfigurationProperty configuration) {
        super(type, placeholder, required, spacing);
        this.nativeHtml5 = nativeHtml5;
        this.configuration = configuration;
    }

}
