package com.brizy.io.web.interactions.page.editor.sidebar.cms.assets.pages.table;

import com.brizy.io.web.interactions.dto.editor.sidebar.cms.assets.pages.PagesTableContentDto;
import com.brizy.io.web.interactions.element.table.Table;
import com.brizy.io.web.interactions.locators.common.TableLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PagesTable extends Table {

    public PagesTable(TableLocators table, Frame frame) {
        super(table, frame);
    }

    List<List<String>> getContent() {
        return getRows();
    }

    @Override
    public PagesTableContentDto getData() {
        return PagesTableContentDto.builder()
                .content(getContent())
                .build();
    }
}
