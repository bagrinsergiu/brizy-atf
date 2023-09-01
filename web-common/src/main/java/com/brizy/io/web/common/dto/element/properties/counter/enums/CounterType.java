package com.brizy.io.web.common.dto.element.properties.counter.enums;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum CounterType implements Enumerable<CounterType> {

    TEXT("nc-counter-style-1"),
    CIRCLE_TEXT("nc-counter-style-2"),
    CIRCLE("nc-counter-style-3"),
    PIE("nc-counter-style-4");

    @Getter
    String value;

    @Override
    public CounterType[] getValues() {
        return CounterType.values();
    }

}
