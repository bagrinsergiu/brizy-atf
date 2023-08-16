package com.brizy.io.web.common.dto.element.properties.common;

import java.util.Arrays;

public interface Enumerable<E extends Enum<E> & Enumerable<E>>{

    E[] getValues();

    String getValue();

    default E getEnumByValue(String value){
        return Arrays.stream(getValues())
                .filter(el -> el.getValue().equals(value))
                .findFirst()
                .orElseThrow();
    }

}
