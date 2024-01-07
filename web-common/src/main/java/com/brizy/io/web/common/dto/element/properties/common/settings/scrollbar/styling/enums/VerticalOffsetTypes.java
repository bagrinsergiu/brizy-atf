package com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.enums;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum VerticalOffsetTypes implements Enumerable<VerticalOffsetTypes> {

    TOP("nc-align-top"),
    BOTTOM("nc-align-bottom");

    @Getter
    String value;

    @Override
    public VerticalOffsetTypes[] getValues() {
        return VerticalOffsetTypes.values();
    }

}
