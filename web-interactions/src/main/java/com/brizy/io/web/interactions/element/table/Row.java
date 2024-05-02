package com.brizy.io.web.interactions.element.table;

import com.brizy.io.web.interactions.element.Span;
import com.brizy.io.web.interactions.locators.common.TableLocators;
import com.microsoft.playwright.Locator;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Row extends Span {

    List<Cell> cells;

    public Row(TableLocators tableLocators, Locator locator) {
        super(locator);
        this.cells = initCells(tableLocators.getCell(), locator);
    }

    private List<Cell> initCells(String cell, Locator locator) {
        return locator.locator(cell).all().stream()
                .map(Cell::new)
                .toList();
    }

    public List<String> getContent() {
        return cells.stream()
                .map(Span::getText)
                .toList();
    }


}
