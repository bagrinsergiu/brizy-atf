package com.brizy.io.web.common.dto.element.content.alert.details;

import com.brizy.io.web.common.dto.element.content.alert.details.properties.AlertContentProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
public class AlertCommon<T extends AlertContentProperties> implements com.brizy.io.web.common.dto.element.content.alert.AlertContentProperties {

    String value;
    T properties;

}
