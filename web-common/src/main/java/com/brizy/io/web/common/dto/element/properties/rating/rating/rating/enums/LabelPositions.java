package com.brizy.io.web.common.dto.element.properties.rating.rating.rating.enums;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public enum LabelPositions implements Enumerable<LabelPositions> {

    RIGHT("nc-align-right"),
    LEFT("nc-align-left"),
    NO_LABEL("nc-close");

    String value;

    @Override
    public LabelPositions[] getValues() {
        return LabelPositions.values();
    }

}
