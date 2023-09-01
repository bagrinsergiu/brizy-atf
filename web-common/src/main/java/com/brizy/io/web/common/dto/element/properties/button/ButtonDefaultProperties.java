package com.brizy.io.web.common.dto.element.properties.button;

import com.brizy.io.web.common.dto.element.properties.DefaultProperty;
import com.brizy.io.web.common.dto.element.properties.button.defaults.Typography;
import com.brizy.io.web.common.dto.element.properties.button.defaults.button.Button;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ButtonDefaultProperties implements DefaultProperty {

    Button button;
    Typography typography;

}
