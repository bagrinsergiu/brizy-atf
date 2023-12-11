package com.brizy.io.web.interactions.page.factory.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum ComponentClassNames {

    AUDIO("brz-soundcloud"),
    BUTTON("brz-btn"),
    COUNTER("brz-counter"),
    FORM("brz-forms2"),
    ICON("brz-icon__container"),
    IMAGE("brz-image"),
    LOTTIE("brz-lottie"),
    MAP("brz-map"),
    PLAYLIST("brz-video-playlist"),
    SPACER("brz-ed-box__resizer"),
    TEXT("brz-rich-text"),
    VIDEO("brz-video ");

    @Getter
    String value;

}
