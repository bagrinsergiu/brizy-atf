package com.brizy.io.web.common.dto.element.properties.button.button.button;

import com.brizy.io.web.common.dto.element.properties.button.button.button.corner.CornerProperties;
import com.brizy.io.web.common.dto.element.properties.button.button.button.fill.FillTypes;
import com.brizy.io.web.common.dto.element.properties.button.button.button.size.ButtonSizeProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ButtonTabProperties {

    ButtonSizeProperties size;
    FillTypes fill;
    CornerProperties corner;

}
