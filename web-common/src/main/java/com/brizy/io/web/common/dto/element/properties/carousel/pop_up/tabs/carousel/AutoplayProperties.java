package com.brizy.io.web.common.dto.element.properties.carousel.pop_up.tabs.carousel;


import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AutoplayProperties {

    Boolean state;
    InputWithUnitsProperties speed;
    InputWithUnitsProperties stopTime;

}
