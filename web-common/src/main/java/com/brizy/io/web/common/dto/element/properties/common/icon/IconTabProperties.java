package com.brizy.io.web.common.dto.element.properties.common.icon;

import com.brizy.io.web.common.dto.element.properties.common.icon.align.IconAligns;
import com.brizy.io.web.common.dto.element.properties.common.icon.picker.IconPickerProperties;
import com.brizy.io.web.common.dto.element.properties.common.icon.size.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IconTabProperties {

    IconPickerProperties icon;
    IconAligns align;
    Size size;
    Integer spacing;

}
