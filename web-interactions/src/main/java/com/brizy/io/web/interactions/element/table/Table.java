package com.brizy.io.web.interactions.element.table;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.TableContentDto;
import com.brizy.io.web.interactions.element.AbstractElement;
import com.brizy.io.web.interactions.element.Span;
import com.brizy.io.web.interactions.locators.common.TableLocators;
import com.microsoft.playwright.Frame;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public abstract class Table extends AbstractElement {

    Supplier<List<ColumnCell>> columns;
    Supplier<List<Row>> rows;

    public Table(TableLocators tableLocators, Frame frame) {
        super(frame.locator(tableLocators.getSelf()));
        this.columns = () -> initColumns(tableLocators.getColumns(), frame);
        this.rows = () -> initRowData(tableLocators, frame);
    }

    List<ColumnCell> initColumns(String columns, Frame frame) {
        return frame.locator(columns).all().stream()
                .map(ColumnCell::new)
                .toList();
    }

    public abstract TableContentDto getData();

    public List<String> getColumnNames() {
        return columns.get().stream()
                .filter(span -> Objects.nonNull(span.getText()) && !span.getText().isBlank())
                .map(Span::getText)
                .toList();
    }

    public List<Row> initRowData(TableLocators tableLocators, Frame frame) {
        return frame.locator(tableLocators.getRows()).all().stream()
                .map(row -> new Row(tableLocators, row))
                .toList();
    }

    public List<List<String>> getRows() {
        return rows.get().stream()
                .map(Row::getContent)
                .toList();
    }


}
