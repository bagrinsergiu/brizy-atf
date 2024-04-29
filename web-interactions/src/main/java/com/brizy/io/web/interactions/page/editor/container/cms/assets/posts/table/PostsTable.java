package com.brizy.io.web.interactions.page.editor.container.cms.assets.posts.table;

import com.brizy.io.web.interactions.element.table.AbstractTable;
import com.brizy.io.web.interactions.element.table.Cell;
import com.brizy.io.web.interactions.locators.common.AbstractTableLocators;
import com.brizy.io.web.interactions.locators.editor.cms.assets.table.AssetsTableLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import io.vavr.Function7;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PostsTable extends AbstractTable {

    public PostsTable(AssetsTableLocators table, Frame frame) {
        super(table, frame);
    }

    @Override
    public Function7<AbstractTableLocators, Integer, Integer, Boolean, Locator, Locator, Locator, Cell> getInitCell() {
        return PostsCellWithActions::new;
    }

}
