package com.brizy.io.web.test.types.data_table;

import com.brizy.io.web.test.model.page.Item;
import io.cucumber.java.DataTableType;
import lombok.SneakyThrows;

import java.util.Map;

import static com.brizy.io.web.test.model.page.Item.Fields.*;

public class PageItemDataTable {

    @DataTableType
    @SneakyThrows
    public Item getPageItems(Map<String, String> dataTable) {
        return Item.builder()
                .position(dataTable.get(position))
                .item(dataTable.get(item))
                .parent(dataTable.get(parent))
                .name(dataTable.get(name))
                .sectionName(dataTable.get(sectionName))
                .build();
    }

}
