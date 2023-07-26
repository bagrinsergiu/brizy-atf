package com.brizy.io.web.common.dto.element.properties.toolbar.common.settings;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum UnitType {

    PERCENTAGE("%"),
    PIXEL("px");

    @Getter
    String value;

}
