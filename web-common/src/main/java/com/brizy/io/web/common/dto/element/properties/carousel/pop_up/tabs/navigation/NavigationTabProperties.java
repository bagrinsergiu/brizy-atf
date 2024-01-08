package com.brizy.io.web.common.dto.element.properties.carousel.pop_up.tabs.navigation;

import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NavigationTabProperties {

    String arrows;
    InputWithUnitsProperties spacing;
    String dots;

}
