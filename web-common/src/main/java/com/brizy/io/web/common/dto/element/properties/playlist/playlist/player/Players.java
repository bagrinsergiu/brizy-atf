package com.brizy.io.web.common.dto.element.properties.playlist.playlist.player;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public enum Players {

    YOUTUBE("YouTube"),
    VIMEO("Vimeo");

    String value;

}
