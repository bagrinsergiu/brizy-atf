package com.brizy.io.web.test.types.parameter_type;

import com.brizy.io.web.interactions.enums.ContextMenuActions;
import com.brizy.io.web.test.enums.StorageKey;
import io.cucumber.java.ParameterType;

public class ComparableType {

    @ParameterType(name = "comparable", value = "first|second")
    public StorageKey comparable(String rawValue) {
        if (rawValue.equals("first")) {
            return StorageKey.FIRST;
        }
        return StorageKey.SECOND;
    }

}
