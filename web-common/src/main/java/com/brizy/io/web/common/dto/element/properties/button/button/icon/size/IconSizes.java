package com.brizy.io.web.common.dto.element.properties.button.button.icon.size;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum IconSizes implements Enumerable<IconSizes> {

    SIZE_16("nc-16"),
    SIZE_24("nc-24"),
    SIZE_32("nc-32"),
    CUSTOM("nc-more");

    @Getter
    String value;

    @Override
    public IconSizes[] getValues() {
        return IconSizes.values();
    }
}
