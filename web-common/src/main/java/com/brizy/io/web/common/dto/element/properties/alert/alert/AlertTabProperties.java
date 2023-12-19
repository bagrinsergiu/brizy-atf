package com.brizy.io.web.common.dto.element.properties.alert.alert;

import com.brizy.io.web.common.dto.element.properties.alert.alert.alert.Alert;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AlertTabProperties {

    Alert alert;

}
