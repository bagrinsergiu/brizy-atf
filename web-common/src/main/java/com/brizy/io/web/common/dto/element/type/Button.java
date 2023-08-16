package com.brizy.io.web.common.dto.element.type;

import com.brizy.io.web.common.dto.element.properties.DefaultProperty;
import com.brizy.io.web.common.dto.element.properties.button.ButtonDefaultProperties;
import com.brizy.io.web.common.dto.element.properties.button.ButtonProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Button extends AbstractPropertyType<ButtonProperties> implements ItemType {

    ButtonProperties properties;
    ButtonDefaultProperties defaultProperties;
}
