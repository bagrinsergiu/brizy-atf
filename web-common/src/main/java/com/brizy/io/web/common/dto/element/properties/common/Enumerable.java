package com.brizy.io.web.common.dto.element.properties.common;

public interface Enumerable<E extends Enum<E> & Enumerable<E>>{

    E[] getValues();

    String getValue();

}
