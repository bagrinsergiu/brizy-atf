package com.brizy.io.web.common.dto.element.properties.image.image.align;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public enum Aligns {

    LEFT("align-left"),
    RIGHT("align-right"),
    CENTER("align-center"),
    JUSTIFY("align-justify");

    String value;

}
