package com.brizy.io.web.common.dto.element.properties.carousel.pop_up;

import com.brizy.io.web.common.dto.element.properties.carousel.pop_up.tabs.carousel.CarouselTabProperties;
import com.brizy.io.web.common.dto.element.properties.carousel.pop_up.tabs.navigation.NavigationTabProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CarouselPopUpProperties {

    CarouselTabProperties carousel;
    NavigationTabProperties navigation;

}
