package com.brizy.io.web.test.types.data_table;

import com.brizy.io.web.test.model.SaveDraftMenuItem;
import io.cucumber.java.DataTableType;
import lombok.SneakyThrows;

import java.util.Map;

import static com.brizy.io.web.test.model.SaveDraftMenuItem.Fields.*;

public class SaveDraftMenuItemDataTable {

    @DataTableType
    @SneakyThrows
    public SaveDraftMenuItem getEditorBottomPanelItems(Map<String, String> dataTable) {
        return SaveDraftMenuItem.builder()
                .name(dataTable.get(name))
                .tooltip(dataTable.get(tooltip))
                .isEnabled(Boolean.valueOf(dataTable.get(isEnabled)))
                .build();
    }

}
