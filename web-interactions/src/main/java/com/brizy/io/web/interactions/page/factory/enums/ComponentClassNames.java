package com.brizy.io.web.interactions.page.factory.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum ComponentClassNames {

    AUDIO("brz-soundcloud"),
    ALERT("brz-alert"),
    BUTTON("brz-btn"),
    CALENDLY("brz-calendly"),
    CAROUSEL("brz-carousel"),
    COUNTER("brz-counter"),
    COUNTDOWN("brz-countdown2"),
    FORM("brz-forms2"),
    ICON("brz-icon__container"),
    IMAGE("brz-image"),
    LINE("brz-line"),
    LOTTIE("brz-lottie"),
    MAP("brz-map"),
    PLAYLIST("brz-video-playlist"),
    PROGRESS_BAR("brz-progress-bar"),
    RATING("brz-starrating"),
    SPACER("brz-ed-box__resizer"),
    TEXT("brz-rich-text"),
    VIDEO("brz-video ");

    @Getter
    String value;

}
