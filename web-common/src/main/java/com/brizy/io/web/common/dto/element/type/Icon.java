package com.brizy.io.web.common.dto.element.type;

import com.brizy.io.web.common.dto.element.properties.button.ButtonProperties;
import com.brizy.io.web.common.dto.element.properties.icon.IconProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Icon extends AbstractPropertyType<IconProperties> implements ItemType {

    IconProperties properties;

}
