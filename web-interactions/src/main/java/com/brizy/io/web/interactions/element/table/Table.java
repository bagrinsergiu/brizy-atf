package com.brizy.io.web.interactions.element.table;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.TableContentDto;

import java.util.List;
import java.util.Optional;

public interface Table {

    List<Cell> getCells();

    TableContentDto getData();

    List<List<String>> getRawData();

    <T> boolean hasValueInColumn(T valueToCheck, String columnName);

    <T> List<T> getValuesInColumn(Class<T> clazz, String columnName);

    <T> Optional<Cell> findCellByValueInColumn(T valueToFilterBy, String columnName);

    Optional<Cell> findCellInColumnAndRowId(String columnName, int rowId);

    Optional<Cell> findCellInColumnIdAndRowId(int columnId, int rowId);

}
