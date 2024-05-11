package com.brizy.io.web.interactions.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum PublishedItems {

    DRAFT("Draft"),
    PUBLISHED("Published"),
    PROTECTED("Protected");

    @Getter
    String name;

}
