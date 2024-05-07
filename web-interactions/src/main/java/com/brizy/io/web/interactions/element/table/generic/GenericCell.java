package com.brizy.io.web.interactions.element.table.generic;

import com.brizy.io.web.interactions.element.Element;
import com.brizy.io.web.interactions.element.Span;
import com.brizy.io.web.interactions.element.table.Cell;
import com.brizy.io.web.interactions.element.table.Column;
import com.brizy.io.web.interactions.element.table.Row;
import com.brizy.io.web.interactions.locators.common.AbstractTableColumnLocators;
import com.brizy.io.web.interactions.locators.common.AbstractTableLocators;
import com.brizy.io.web.interactions.locators.common.AbstractTableRowLocators;
import com.microsoft.playwright.Locator;
import io.vavr.Function3;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.function.Function;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GenericCell implements Cell {

    protected Function3<AbstractTableColumnLocators, Integer, Locator, Column> initColumn = GenericColumn::new;
    protected Function3<AbstractTableRowLocators, Integer, Locator, Row> initRow = GenericRow::new;
    protected Function<Locator, Element> initElement = Span::new;
    @Getter
    Column column;
    @Getter
    Row row;
    Element element;
    boolean isColumn;

    public GenericCell(AbstractTableLocators tableCellLocators, int columnId, int rowId, boolean isColumn, Locator columnLocator, Locator rowLocator, Locator cellLocator) {
        this.column = initColumn.apply(tableCellLocators.getColumns(), columnId, columnLocator);
        this.row = initRow.apply(tableCellLocators.getRows(), rowId, rowLocator);
        this.element = initElement.apply(cellLocator);
        this.isColumn = isColumn;
    }

    @Override
    public boolean isColumn() {
        return isColumn;
    }

    @Override
    public <T> T getContent(Class<T> clazzToCastTo) {
        return element.getText(clazzToCastTo);
    }

}
