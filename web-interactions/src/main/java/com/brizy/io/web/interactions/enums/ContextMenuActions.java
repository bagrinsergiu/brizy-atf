package com.brizy.io.web.interactions.enums;

import io.vavr.control.Try;

public enum ContextMenuActions {

    COPY,
    PASTE,
    PASTE_STYLES,
    DUPLICATE,
    DELETE;

    /**
     * @param name if the name is an invalid one or paste styles - PASTE_STYLES will be returned
     * @return
     */
    public static ContextMenuActions getByValue(String name) {
        return Try.of(() -> ContextMenuActions.valueOf(name))
                .getOrElse(PASTE_STYLES);
    }

}
