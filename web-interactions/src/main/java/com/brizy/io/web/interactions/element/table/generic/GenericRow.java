package com.brizy.io.web.interactions.element.table.generic;

import com.brizy.io.web.interactions.element.Element;
import com.brizy.io.web.interactions.element.Span;
import com.brizy.io.web.interactions.element.table.Row;
import com.brizy.io.web.interactions.locators.common.AbstractTableRowLocators;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GenericRow implements Row {

    Element element;
    @Getter
    int id;

    public GenericRow(AbstractTableRowLocators abstractTableRowLocators, Integer rowId, Locator locator) {
        this.element = new Span(locator);
        this.id = rowId;
    }

    @Override
    public <T> T getContent(Class<T> clazzToCastContentTo) {
        return element.getText(clazzToCastContentTo);
    }
}
