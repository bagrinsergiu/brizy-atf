package com.brizy.io.web.interactions.page.factory.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum ComponentClassNames {

    MAP("brz-map"),
    GALLERY("brz-image__gallery"),
    FORM("brz-forms2"),
    COUNTER("brz-counter"),
    TEXT("brz-rich-text"),
    BUTTON("brz-btn"),
    ICON("brz-icon__container"),
    SPACER("brz-ed-box__resizer"),
    IMAGE("brz-image");

    @Getter
    String value;

}
