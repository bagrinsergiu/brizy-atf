package com.brizy.io.web.common.dto.element.properties.form.field.type;

import com.brizy.io.web.common.dto.element.properties.form.field.configuration.type.FieldWithOptionsConfigurationProperty;
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
public class SelectFieldProperty extends AbstractFieldProperty {

    boolean multipleSelection;
    FieldWithOptionsConfigurationProperty configuration;

    public SelectFieldProperty(Integer spacing, String type, String placeholder, boolean required, boolean multipleSelection, FieldWithOptionsConfigurationProperty configuration) {
        super(type, placeholder, required, spacing);
        this.multipleSelection = multipleSelection;
        this.configuration = configuration;
    }

}
