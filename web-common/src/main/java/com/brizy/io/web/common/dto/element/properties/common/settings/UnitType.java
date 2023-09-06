package com.brizy.io.web.common.dto.element.properties.common.settings;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum UnitType {

    PERCENTAGE("%"),
    PIXEL("px");

    @Getter
    String value;

    public static UnitType getByValue(String value) {
        return Arrays.stream(UnitType.values())
                .filter(enumElement -> enumElement.getValue().equals(value))
                .findFirst()
                .orElse(PIXEL);
    }

}
