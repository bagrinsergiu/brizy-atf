package com.brizy.io.web.test.types.data_table;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.abstracts.NewContentDto;
import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.pages.NewPageContentDto;
import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.pages.NewPageDescriptionDto;
import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.posts.NewPostContentDto;
import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.posts.NewPostExcerptDto;
import com.brizy.io.web.interactions.enums.PublishedItems;
import com.brizy.io.web.test.data.enums.TestDataFileType;
import com.brizy.io.web.test.data.service.TestDataFileService;
import com.brizy.io.web.test.service.PatternReplacerService;
import io.cucumber.java.DataTableType;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Optional;

public class NewContentDataTable {

    @Autowired
    TestDataFileService testDataFileService;
    @Autowired
    PatternReplacerService patternReplacerService;

    @DataTableType
    public NewContentDto newContentDataTable(Map<String, String> dataTable) {
        var itemType = dataTable.get("Item").toLowerCase().trim();
        return switch (itemType) {
            case "page" -> getNewPageContent(dataTable);
            case "post" -> getNewPostContent(dataTable);
            default -> throw new NotImplementedException(String.format("Unknown item %s", itemType));
        };
    }

    NewContentDto getNewPostContent(Map<String, String> dataTable) {
        dataTable = patternReplacerService.processDataTable(dataTable);
        return NewPostContentDto.builder()
                .title(dataTable.get("Title").trim())
                .slug(Optional.ofNullable(dataTable.get("Slug")).map(String::trim).orElse(null))
                .excerpt(NewPostExcerptDto.builder().text(dataTable.get("Excerpt").trim()).build())
                .featuredImage(testDataFileService.getResourceFilePath(TestDataFileType.FILE, dataTable.get("Featured Image")))
                .published(PublishedItems.valueOf(dataTable.get("Published").trim().toUpperCase()))
                .build();
    }

    NewContentDto getNewPageContent(Map<String, String> dataTable) {
        dataTable = patternReplacerService.processDataTable(dataTable);
        return NewPageContentDto.builder()
                .title(dataTable.get("Title").trim())
                .slug(Optional.ofNullable(dataTable.get("Slug")).map(String::trim).orElse(null))
                .description(NewPageDescriptionDto.builder().text(dataTable.get("Description").trim()).build())
                .published(PublishedItems.valueOf(dataTable.get("Published").trim().toUpperCase()))
                .build();
    }

}