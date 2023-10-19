package com.brizy.io.web.common.dto.element.properties.form.field;

import com.brizy.io.web.common.dto.element.properties.form.field.advanced.AdvancedFieldProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.background.BackgroundFieldProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.type.FieldsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
public class FieldProperties {

    AdvancedFieldProperties advanced;
    BackgroundFieldProperties background;
    List<FieldsProperties> fields;

}
