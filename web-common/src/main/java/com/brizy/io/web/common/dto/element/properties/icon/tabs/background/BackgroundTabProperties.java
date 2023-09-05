package com.brizy.io.web.common.dto.element.properties.icon.tabs.background;

import com.brizy.io.web.common.dto.element.properties.common.corner.CornerProperties;
import com.brizy.io.web.common.dto.element.properties.common.fill.FillTypes;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BackgroundTabProperties {

    FillTypes fill;
    CornerProperties corner;
    Integer size;

}
