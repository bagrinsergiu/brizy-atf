package com.brizy.io.web.common.dto.element.properties.common.settings;

import com.brizy.io.web.common.dto.element.properties.common.InputWithUnitsProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SettingsProperties implements CanHaveSettings {

    InputWithUnitsProperties width;
    InputWithUnitsProperties height;

}
