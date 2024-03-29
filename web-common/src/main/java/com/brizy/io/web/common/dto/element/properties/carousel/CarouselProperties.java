package com.brizy.io.web.common.dto.element.properties.carousel;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.carousel.pop_up.CarouselPopUpProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithWidthEffectsAndStylingProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CarouselProperties implements Property {

    CarouselPopUpProperties carousel;
    SettingsWithWidthEffectsAndStylingProperties settings;

}
