package com.brizy.io.web.common.dto.element.properties.common.settings.settings.styling.enums;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum HorizontalOffsetTypes implements Enumerable<HorizontalOffsetTypes> {

    LEFT("nc-align-left"),
    RIGHT("nc-align-right");

    @Getter
    String value;

    @Override
    public HorizontalOffsetTypes[] getValues() {
        return HorizontalOffsetTypes.values();
    }

}
