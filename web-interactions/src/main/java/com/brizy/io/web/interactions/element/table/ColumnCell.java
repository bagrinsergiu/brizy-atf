package com.brizy.io.web.interactions.element.table;

import com.brizy.io.web.interactions.element.Span;
import com.microsoft.playwright.Locator;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ColumnCell extends Span {

    public ColumnCell(Locator locator) {
        super(locator);
    }

}
