package com.brizy.io.web.common.dto.element.properties.button.button.icon;

import com.brizy.io.web.common.dto.element.properties.button.button.icon.align.IconAligns;
import com.brizy.io.web.common.dto.element.properties.button.button.icon.size.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IconTabProperties {

    String icon;
    IconAligns align;
    Size size;
    Integer spacing;

}
