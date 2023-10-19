package com.brizy.io.web.common.dto.element.properties.form.field.type;

import com.brizy.io.web.common.dto.element.properties.form.field.configuration.type.FileFieldConfigurationProperty;
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
public class FileFieldProperty extends AbstractFieldProperty {

    FileFieldConfigurationProperty configuration;

    public FileFieldProperty(Integer spacing, String type, String placeholder, boolean required, FileFieldConfigurationProperty configuration) {
        super(type, placeholder, required, spacing);
        this.configuration = configuration;
    }

}
