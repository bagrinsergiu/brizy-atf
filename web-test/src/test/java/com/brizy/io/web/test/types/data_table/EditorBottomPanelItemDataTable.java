package com.brizy.io.web.test.types.data_table;

import com.brizy.io.web.test.model.EditorBottomPanelItem;
import io.cucumber.java.DataTableType;
import lombok.SneakyThrows;

import java.util.Map;

import static com.brizy.io.web.test.model.EditorBottomPanelItem.Fields.*;

public class EditorBottomPanelItemDataTable {

    @DataTableType
    @SneakyThrows
    public EditorBottomPanelItem getEditorBottomPanelItems(Map<String, String> dataTable) {
        return EditorBottomPanelItem.builder()
                .name(dataTable.get(name))
                .tooltip(dataTable.get(tooltip))
                .isEnabled(Boolean.valueOf(dataTable.get(isEnabled)))
                .build();
    }

}
