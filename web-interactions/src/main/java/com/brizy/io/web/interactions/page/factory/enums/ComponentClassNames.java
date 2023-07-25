package com.brizy.io.web.interactions.page.factory.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum ComponentClassNames {

    MAP("brz-map"),
    COUNTER("brz-counter"),
    BUTTON("brz-d-xs-flex");

    @Getter
    String value;

}
