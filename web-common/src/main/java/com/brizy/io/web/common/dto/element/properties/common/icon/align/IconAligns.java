package com.brizy.io.web.common.dto.element.properties.common.icon.align;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum IconAligns implements Enumerable<IconAligns> {

    LEFT("nc-align-left"),
    RIGHT("nc-align-right");

    @Getter
    String value;

    @Override
    public IconAligns[] getValues() {
        return IconAligns.values();
    }
}
