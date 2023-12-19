package com.brizy.io.web.common.dto.element.properties.button.button;

import com.brizy.io.web.common.dto.element.properties.button.button.button.ButtonTabProperties;
import com.brizy.io.web.common.dto.element.properties.common.icon.IconTabProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ButtonProperties {

    ButtonTabProperties button;
    IconTabProperties icon;

}
