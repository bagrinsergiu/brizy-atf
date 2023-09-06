package com.brizy.io.web.common.dto.element.properties.common.fill;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum FillTypes implements Enumerable<FillTypes> {

    BOARDER("nc-outline"),
    FILL("nc-circle"),
    NO_FILL("nc-close");

    @Getter
    String value;

    @Override
    public FillTypes[] getValues() {
        return FillTypes.values();
    }

}
