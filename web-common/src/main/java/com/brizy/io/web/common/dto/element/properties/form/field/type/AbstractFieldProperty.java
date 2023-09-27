package com.brizy.io.web.common.dto.element.properties.form.field.type;

import com.brizy.io.web.common.dto.element.properties.form.field.configuration.FieldConfigurationProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.configuration.type.EmptyFieldConfigurationProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AbstractFieldProperty implements FieldsProperties {

    String type;
    String placeholder;
    boolean required;
    Integer spacing;

    @Override
    public FieldConfigurationProperties getConfiguration() {
        return new EmptyFieldConfigurationProperties();
    }

}
