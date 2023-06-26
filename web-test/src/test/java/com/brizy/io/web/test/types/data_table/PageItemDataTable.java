package com.brizy.io.web.test.types.data_table;

import com.brizy.io.web.test.model.page.Item;
import com.brizy.io.web.test.model.page.PageItemProperty;
import io.cucumber.java.DataTableType;
import io.vavr.NotImplementedError;
import lombok.SneakyThrows;

import java.util.Map;

public class PageItemDataTable {

    @DataTableType
    @SneakyThrows
    public Item getPageItems(Map<String, String> dataTable) {
        return Item.builder()
                .position(dataTable.get(Item.Fields.position))
                .item(dataTable.get(Item.Fields.item))
                .parent(dataTable.get(Item.Fields.parent))
                .name(dataTable.get(Item.Fields.name))
                .build();
    }

    @DataTableType
    public PageItemProperty getPageItemProperties(Map<String, String> dataTable) {
        throw new NotImplementedError();
    }


}
