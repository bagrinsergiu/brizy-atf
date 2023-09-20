package com.brizy.io.web.common.dto.element.properties.form.field.type;

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
public class EmailFieldProperty extends AbstractFieldProperty {

    public EmailFieldProperty(Integer spacing, String type, String placeholder, boolean required) {
        super(type, placeholder, required, spacing);
    }

}
