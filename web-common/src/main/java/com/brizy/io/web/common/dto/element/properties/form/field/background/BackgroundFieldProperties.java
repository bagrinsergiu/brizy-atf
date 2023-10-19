package com.brizy.io.web.common.dto.element.properties.form.field.background;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
public class BackgroundFieldProperties {

    BackgroundSizes size;

}
