package com.brizy.io.web.common.dto.element.properties.button.button;

import com.brizy.io.web.common.dto.element.properties.button.button.button.ButtonTabProperties;
import com.brizy.io.web.common.dto.element.properties.button.button.icon.IconTabProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ButtonProperties {

    ButtonTabProperties button;
    IconTabProperties icon;

}
