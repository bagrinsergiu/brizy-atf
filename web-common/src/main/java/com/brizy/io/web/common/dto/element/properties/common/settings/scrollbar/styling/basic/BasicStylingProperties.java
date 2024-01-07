package com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic;


import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.margin.MarginProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.padding.PaddingProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.position.PositionProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BasicStylingProperties {

    PaddingProperties padding;
    MarginProperties margin;
    PositionProperties position;

}
