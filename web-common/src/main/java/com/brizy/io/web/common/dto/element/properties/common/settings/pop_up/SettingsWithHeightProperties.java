package com.brizy.io.web.common.dto.element.properties.common.settings.pop_up;

import com.brizy.io.web.common.dto.element.properties.common.settings.HasHeight;
import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SettingsWithHeightProperties implements HasHeight {

    InputWithUnitsProperties height;

}
