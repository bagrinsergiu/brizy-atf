package com.brizy.io.web.common.dto.element.properties.spacer;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.properties.common.settings.pop_up.SettingsWithHeightProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Data
public class SpacerProperties implements Property {

    SettingsWithHeightProperties settings;

}
