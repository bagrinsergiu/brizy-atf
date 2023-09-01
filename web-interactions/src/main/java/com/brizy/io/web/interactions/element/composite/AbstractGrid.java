package com.brizy.io.web.interactions.element.composite;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.GridLocators;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public abstract class AbstractGrid implements Grid {

    Supplier<List<Locator>> items;
    Function<String, Supplier<Locator>> itemByName;

    public AbstractGrid(GridLocators gridLocators, Page frame) {
        this.items = () -> frame.locator(gridLocators.getItems()).all();
        this.itemByName = (itemName) -> () -> frame.locator(String.format(gridLocators.getItem(), itemName));
    }

    public void select(String itemName) {
        Locator foundItem = itemByName.apply(itemName).get();
        foundItem.scrollIntoViewIfNeeded();
        foundItem.click();
    }

}
