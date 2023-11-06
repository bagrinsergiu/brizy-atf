package com.brizy.io.web.common.dto.element.properties.video.video.video.player;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public enum Players {

    YOUTUBE("YouTube"),
    VIMEO("Vimeo"),
    CUSTOM_VIDEO("Custom Video"),
    URL("URL");

    String value;

}
