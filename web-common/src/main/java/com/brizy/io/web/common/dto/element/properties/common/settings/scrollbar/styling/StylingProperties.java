package com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling;


import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.advanced.AdvancedStylingProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.BasicStylingProperties;
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
