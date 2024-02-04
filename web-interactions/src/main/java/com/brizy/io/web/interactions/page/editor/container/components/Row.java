package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.interactions.locators.editor.workspace.section.SectionLocators;
import com.brizy.io.web.interactions.page.editor.container.AbstractContainer;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;

import java.util.List;

public class Row extends AbstractContainer {

    List<Column> columns;

    public Row(Frame frame, Locator componentLocator, SectionLocators sectionLocators) {
        super(sectionLocators, frame, componentLocator);
        this.columns = ColumnGroup.initColumns(frame, componentLocator, sectionLocators);
    }

    public Column getColumn(String columnName) {
        return columns.stream()
                .filter(column -> column.getName().equals(columnName))
                .findFirst()
                .orElse(new Column());
    }

}
