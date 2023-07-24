package com.brizy.io.web.test.types.data_table;

import com.brizy.io.web.test.model.ContextMenuItem;
import io.cucumber.java.DataTableType;
import lombok.SneakyThrows;

import java.util.Map;

import static com.brizy.io.web.test.model.ContextMenuItem.Fields.*;

public class ContextMenuItemDataTable {

    @DataTableType
    @SneakyThrows
    public ContextMenuItem getContextMenuItems(Map<String, String> dataTable) {
        return ContextMenuItem.builder()
                .title(dataTable.get(title))
                .keyShortcut(dataTable.get(keyShortcut))
                .isEnabled(Boolean.valueOf(dataTable.get(isEnabled)))
                .build();
    }

}
