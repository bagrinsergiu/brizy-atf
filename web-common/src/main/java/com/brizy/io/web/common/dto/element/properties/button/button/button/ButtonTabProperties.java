package com.brizy.io.web.common.dto.element.properties.button.button.button;

import com.brizy.io.web.common.dto.element.properties.button.button.button.corner.CornerProperties;
import com.brizy.io.web.common.dto.element.properties.button.button.button.fill.FillTypes;
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
