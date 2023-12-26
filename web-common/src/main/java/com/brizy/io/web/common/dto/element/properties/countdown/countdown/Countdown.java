package com.brizy.io.web.common.dto.element.properties.countdown.countdown;

import com.brizy.io.web.common.dto.element.properties.countdown.countdown.advanced.CountdownAdvancedProperties;
import com.brizy.io.web.common.dto.element.properties.countdown.countdown.timer.CountdownTimerProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Countdown {

    CountdownTimerProperties timer;
    CountdownAdvancedProperties advanced;

}
