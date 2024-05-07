package com.brizy.io.web.interactions.element.table;

interface TableContent {

    int getId();

    <T> T getContent(Class<T> clazzToCastContentTo);

}
