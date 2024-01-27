package com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.icon;

import com.brizy.io.web.common.dto.element.properties.common.icon.picker.IconPickerProperties;
import com.brizy.io.web.common.dto.element.properties.common.icon.size.Size;
import com.brizy.io.web.common.dto.element.properties.elements.InputWithUnitsProperties;
import com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.common.LineAlign;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IconTabProperties {

    IconPickerProperties icon;
    LineAlign align;
    Size size;
    InputWithUnitsProperties spacing;
    InputWithUnitsProperties padding;
    InputWithUnitsProperties rotate;

}
