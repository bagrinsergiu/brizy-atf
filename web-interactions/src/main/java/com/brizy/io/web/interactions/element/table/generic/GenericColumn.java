package com.brizy.io.web.interactions.element.table.generic;

import com.brizy.io.web.interactions.element.Element;
import com.brizy.io.web.interactions.element.Span;
import com.brizy.io.web.interactions.element.table.Column;
import com.brizy.io.web.interactions.locators.common.AbstractTableColumnLocators;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GenericColumn implements Column {

    Element element;
    @Getter
    int id;

    public GenericColumn(AbstractTableColumnLocators abstractTableColumnLocators, Integer columnId, Locator locator) {
        this.element = new Span(locator);
        this.id = columnId;
    }

    @Override
    public <T> T getContent(Class<T> clazzToCastContentTo) {
        return element.getText(clazzToCastContentTo);
    }

}
