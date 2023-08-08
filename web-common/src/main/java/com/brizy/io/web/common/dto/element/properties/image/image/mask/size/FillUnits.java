package com.brizy.io.web.common.dto.element.properties.image.image.mask.size;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum FillUnits {

    PX("px"),
    PERCENT("%");

    @Getter
    String value;

}
