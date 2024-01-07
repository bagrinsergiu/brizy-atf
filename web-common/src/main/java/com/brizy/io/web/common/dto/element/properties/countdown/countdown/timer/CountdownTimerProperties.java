package com.brizy.io.web.common.dto.element.properties.countdown.countdown.timer;

import com.brizy.io.web.common.dto.element.properties.countdown.enums.CountdownStyles;
import com.brizy.io.web.common.dto.element.properties.elements.DropdownWithPopulationProperties;
import com.brizy.io.web.common.dto.element.properties.elements.InputWithPopulationProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CountdownTimerProperties {

    CountdownStyles style;
    InputWithPopulationProperties date;
    DropdownWithPopulationProperties hour;
    DropdownWithPopulationProperties minutes;
    String timeZone;

}
