package com.brizy.io.web.common.dto.element.properties.rating.rating.icons;

import com.brizy.io.web.common.dto.element.properties.common.InputWithUnitsProperties;
import com.brizy.io.web.common.dto.element.properties.common.icon.picker.IconPickerProperties;
import com.brizy.io.web.common.dto.element.properties.common.icon.size.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IconsTabProperties {

    IconPickerProperties icon;
    Size size;
    InputWithUnitsProperties spacing;

}
