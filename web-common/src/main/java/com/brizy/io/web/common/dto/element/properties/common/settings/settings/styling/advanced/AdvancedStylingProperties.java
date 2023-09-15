package com.brizy.io.web.common.dto.element.properties.common.settings.settings.styling.advanced;


import com.brizy.io.web.common.dto.element.properties.common.InputWithPopulationProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AdvancedStylingProperties {

    Boolean showOnDesktop;
    Integer zIndex;
    InputWithPopulationProperties cssId;
    InputWithPopulationProperties cssClass;
    InputWithPopulationProperties customAttributes;
    String customCss;
    Integer hoverTransition;

}
