package com.brizy.io.web.common.dto.element.properties.alert.alert.alert;

import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Alert {

    Boolean displayCloseButton;
    Boolean displayDescription;
    InputWithUnitsProperties delay;

}
