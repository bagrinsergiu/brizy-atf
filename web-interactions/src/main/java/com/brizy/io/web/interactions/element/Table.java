package com.brizy.io.web.interactions.element;

import com.brizy.io.web.interactions.locators.common.TableLocators;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Table extends AbstractElement {

    public Table(TableLocators tableLocators, Page page) {
        super(page.locator(tableLocators.getSelf()));
    }



}
