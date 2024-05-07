package com.brizy.io.web.interactions.element.table;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.TableContentDto;
import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.pages.PagesTableContentDto;
import com.brizy.io.web.interactions.element.AbstractElement;
import com.brizy.io.web.interactions.element.table.generic.GenericCell;
import com.brizy.io.web.interactions.locators.common.AbstractTableLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import io.vavr.Function7;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public abstract class AbstractTable extends AbstractElement implements Table {

    Supplier<List<Cell>> cells;
    @Getter
    Function7<AbstractTableLocators, Integer, Integer, Boolean, Locator, Locator, Locator, Cell> initCell;

    public AbstractTable(AbstractTableLocators tableLocators, Frame frame) {
        super(frame.locator(tableLocators.getSelf()));
        this.cells = () -> initCells(tableLocators, locator);
        this.initCell = GenericCell::new;
    }

    protected List<Cell> initCells(AbstractTableLocators tableLocators, Locator locator) {
        List<Cell> cells = new ArrayList<>();
        var columnsList = locator.locator(tableLocators.getColumns().getSelf()).all();
        for (int i = 0; i < columnsList.size(); i++) {
            Cell columnCell = getInitCell().apply(tableLocators, i, 0, true, null, null, columnsList.get(i));
            cells.add(columnCell);
        }
        List<Locator> rowsList = locator.locator(tableLocators.getRows().getSelf()).all();
        for (int rowIndex = 0; rowIndex < rowsList.size(); rowIndex++) {
            Locator currentRow = rowsList.get(rowIndex);
            List<Locator> cellsList = currentRow.locator(tableLocators.getCell().getSelf()).all();
            for (int columnIndex = 0; columnIndex < cellsList.size(); columnIndex++) {
                Locator currentCell = cellsList.get(columnIndex);
                Cell cell = getInitCell().apply(
                        tableLocators,
                        columnIndex,
                        rowIndex,
                        false,
                        columnsList.get(columnIndex),
                        currentRow,
                        currentCell
                );
                cells.add(cell);
            }
        }
        return cells;
    }

    public List<Cell> getCells() {
        return cells.get();
    }

    @Override
    public TableContentDto getData() {
        List<List<String>> rowsData = new ArrayList<>();
        List<String> rowData = new ArrayList<>();
        List<Cell> existingCells = getCells();
        for (int i = 0; i < existingCells.size(); i++) {
            Cell cell = existingCells.get(i);
            var row = cell.getRow();
            rowData.add(cell.getContent(String.class));
            if (i != existingCells.size() - 1) {
                if (row.getId() != existingCells.get(i + 1).getRow().getId()) {
                    rowsData.add(rowData);
                    rowData = new ArrayList<>();
                }
            }
        }
        return PagesTableContentDto.builder()
                .content(rowsData)
                .build();
    }

    @Override
    public List<List<String>> getRawData() {
        return null;
    }

    @Override
    public <T> boolean hasValueInColumn(T valueToCheck, String columnName) {
        return getCells().stream()
                .filter(cell -> cell.getColumn().getContent(String.class).equals(columnName))
                .anyMatch(cell -> cell.getContent(valueToCheck.getClass()).equals(valueToCheck));
    }

    @Override
    public <T> List<T> getValuesInColumn(Class<T> clazz, String columnName) {
        return getCells().stream()
                .filter(cell -> cell.getColumn().getContent(String.class).equals(columnName))
                .map(cell -> cell.getContent(clazz))
                .toList();
    }

    @Override
    public <T> Optional<Cell> findCellByValueInColumn(T valueToFilterBy, String columnName) {
        return getCells().stream()
                .filter(cell -> cell.getColumn().getContent(String.class).equals(columnName))
                .filter(cell -> cell.getContent(valueToFilterBy.getClass()).equals(valueToFilterBy))
                .findFirst();
    }

    @Override
    public Optional<Cell> findCellInColumnAndRowId(String columnName, int rowId) {
        return getCells().stream()
                .filter(cell -> cell.getColumn().getContent(String.class).equals(columnName))
                .filter(cell -> cell.getRow().getId() == rowId)
                .findFirst();
    }

    @Override
    public Optional<Cell> findCellInColumnIdAndRowId(int columnId, int rowId) {
        return getCells().stream()
                .filter(cell -> cell.getColumn().getId() == columnId)
                .filter(cell -> cell.getRow().getId() == rowId)
                .findFirst();
    }

}
