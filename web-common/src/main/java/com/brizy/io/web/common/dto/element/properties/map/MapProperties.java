package com.brizy.io.web.common.dto.element.properties.map;

import com.brizy.io.web.common.dto.element.properties.AbstractProperty;
import com.brizy.io.web.common.dto.element.properties.Property;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MapProperties extends AbstractProperty implements Property {

}
