package com.brizy.io.web.common.dto.element.properties.form.field.configuration.type;

import com.brizy.io.web.common.dto.element.properties.form.field.configuration.FieldConfigurationProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TimeFieldConfigurationProperty implements FieldConfigurationProperties {

    String minTime;
    String maxTime;

}
