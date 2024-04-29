package com.brizy.io.web.interactions.element.table;

public interface Cell {

    boolean isColumn();

    Column getColumn();

    Row getRow();

    <T> T getContent(Class<T> clazzToCastTo);

}
