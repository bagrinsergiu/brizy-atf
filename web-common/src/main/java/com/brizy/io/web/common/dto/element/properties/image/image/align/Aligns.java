package com.brizy.io.web.common.dto.element.properties.image.image.align;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public enum Aligns implements Enumerable<Aligns> {

    LEFT("align-left"),
    RIGHT("align-right"),
    CENTER("align-center"),
    JUSTIFY("align-justify");

    String value;

    @Override
    public Aligns getEnumByValue(String value) {
        return Arrays.stream(Aligns.values())
                .filter(align -> value.contains(align.getValue()))
                .findFirst()
                .orElse(LEFT);
    }

    @Override
    public Aligns[] getEnumConstants() {
        return Aligns.values();
    }

}
