package com.brizy.io.web.common.dto.element.properties.button.settings.styling;


import com.brizy.io.web.common.dto.element.properties.button.settings.styling.advanced.AdvancedStylingProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.styling.basic.BasicStylingProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StylingProperties {

    BasicStylingProperties basic;
    AdvancedStylingProperties advanced;

}
