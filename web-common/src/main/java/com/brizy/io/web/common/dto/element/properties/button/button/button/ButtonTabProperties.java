package com.brizy.io.web.common.dto.element.properties.button.button.button;

import com.brizy.io.web.common.dto.element.properties.common.corner.CornerProperties;
import com.brizy.io.web.common.dto.element.properties.common.fill.FillTypes;
import com.brizy.io.web.common.dto.element.properties.button.button.button.size.ButtonSizeProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder(toBuilder = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ButtonTabProperties {

    ButtonSizeProperties size;
    FillTypes fill;
    CornerProperties corner;

}
