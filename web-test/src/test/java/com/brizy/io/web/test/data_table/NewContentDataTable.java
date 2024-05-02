package com.brizy.io.web.test.data_table;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.NewContentDto;
import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.pages.NewPageContentDto;
import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.pages.NewPageDescriptionDto;
import io.cucumber.java.DataTableType;
import org.apache.commons.lang3.NotImplementedException;

import java.util.Map;
import java.util.Optional;

public class NewContentDataTable {

    @DataTableType
    public NewContentDto newContentDataTable(Map<String, String> dataTable) {
        var itemType = dataTable.get("Item").toLowerCase().trim();
        return switch (itemType) {
            case "page" -> getNewPageContent(dataTable);
            case "story" -> getNewStoryContent(dataTable);
            default -> throw new NotImplementedException(String.format("Unknown item %s", itemType));
        };
    }

    NewContentDto getNewStoryContent(Map<String, String> dataTable) {
        return null;
    }

    NewContentDto getNewPageContent(Map<String, String> dataTable) {
        return NewPageContentDto.builder()
                .pageTitle(dataTable.get("Title").trim())
                .slug(Optional.ofNullable(dataTable.get("Slug")).map(String::trim).orElse(null))
                .description(NewPageDescriptionDto.builder().text(dataTable.get("Description").trim()).build())
                .build();
    }

}