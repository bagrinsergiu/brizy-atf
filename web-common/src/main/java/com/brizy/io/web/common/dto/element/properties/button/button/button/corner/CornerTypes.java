package com.brizy.io.web.common.dto.element.properties.button.button.button.corner;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum CornerTypes implements Enumerable<CornerTypes> {

    SQUARE("nc-corners-square"),
    ROUND("nc-corners-round"),
    CUSTOM("nc-more");

    @Getter
    String value;

    @Override
    public CornerTypes[] getValues() {
        return CornerTypes.values();
    }

}
