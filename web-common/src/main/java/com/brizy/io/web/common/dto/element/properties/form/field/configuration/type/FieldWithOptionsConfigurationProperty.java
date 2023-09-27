package com.brizy.io.web.common.dto.element.properties.form.field.configuration.type;

import com.brizy.io.web.common.dto.element.properties.form.field.configuration.FieldConfigurationProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FieldWithOptionsConfigurationProperty implements FieldConfigurationProperties {

    List<String> options;

}
