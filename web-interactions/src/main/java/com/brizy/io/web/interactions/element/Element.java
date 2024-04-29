package com.brizy.io.web.interactions.element;

public interface Element {

    String getText();

    <T> T getText(Class<T> clazz);

}
