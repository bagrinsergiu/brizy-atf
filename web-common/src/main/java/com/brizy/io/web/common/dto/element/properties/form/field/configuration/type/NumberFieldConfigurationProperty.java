package com.brizy.io.web.common.dto.element.properties.form.field.configuration.type;

import com.brizy.io.web.common.dto.element.properties.form.field.configuration.FieldConfigurationProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.configuration.type.error_message.NumberFieldErrorMessage;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NumberFieldConfigurationProperty implements FieldConfigurationProperties {

    NumberFieldErrorMessage errorMessage;
    Integer minNumber;
    Integer maxNumber;

}
