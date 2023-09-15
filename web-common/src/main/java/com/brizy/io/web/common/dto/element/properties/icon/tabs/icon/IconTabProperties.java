package com.brizy.io.web.common.dto.element.properties.icon.tabs.icon;

import com.brizy.io.web.common.dto.element.properties.button.button.icon.picker.IconPickerProperties;
import com.brizy.io.web.common.dto.element.properties.button.button.icon.size.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IconTabProperties {

    IconPickerProperties icon;
    Size size;

}
