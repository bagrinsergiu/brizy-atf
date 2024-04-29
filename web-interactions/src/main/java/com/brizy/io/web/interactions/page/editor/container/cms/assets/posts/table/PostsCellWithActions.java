package com.brizy.io.web.interactions.page.editor.container.cms.assets.posts.table;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.table.ActionsCell;
import com.brizy.io.web.interactions.element.table.generic.GenericCell;
import com.brizy.io.web.interactions.locators.common.AbstractTableLocators;
import com.brizy.io.web.interactions.locators.editor.cms.assets.table.AssetsTableLocators;
import com.brizy.io.web.interactions.page.editor.container.cms.assets.posts.table.actions.AssetsTableCellActions;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PostsCellWithActions extends GenericCell implements ActionsCell<AssetsTableCellActions> {

    Button edit;
    Button duplicate;
    Button delete;

    public PostsCellWithActions(AbstractTableLocators tableCellLocators, int columnId, int rowId, boolean isColumn, Locator columnLocator, Locator rowLocator, Locator cellLocator) {
        super(tableCellLocators, columnId, rowId, isColumn, columnLocator, rowLocator, cellLocator);
        var actions = ((AssetsTableLocators) tableCellLocators).getCell().getActions();
        this.edit = new Button(cellLocator.locator(actions.getEdit()));
        this.duplicate = new Button(cellLocator.locator(actions.getDuplicate()));
        this.delete = new Button(cellLocator.locator(actions.getDelete()));
    }

    @Override
    public void doAction(AssetsTableCellActions action) {
        switch (action) {
            case EDIT -> edit.click();
            case DUPLICATE -> duplicate.click();
            case DELETE -> delete.click();
        }
    }

}
