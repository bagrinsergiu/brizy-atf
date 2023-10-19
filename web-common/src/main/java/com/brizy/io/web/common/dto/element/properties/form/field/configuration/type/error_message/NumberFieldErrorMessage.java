package com.brizy.io.web.common.dto.element.properties.form.field.configuration.type.error_message;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NumberFieldErrorMessage implements FieldErrorMessageProperties {

    Integer minNumber;
    Integer maxNumber;

}
