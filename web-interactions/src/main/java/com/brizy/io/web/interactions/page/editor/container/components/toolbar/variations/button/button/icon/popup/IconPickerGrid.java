package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon.popup;

import com.brizy.io.web.interactions.element.composite.AbstractGrid;
import com.brizy.io.web.interactions.element.composite.Grid;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.common.GridLocators;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class IconPickerGrid extends AbstractGrid {

    public IconPickerGrid(GridLocators gridLocators, Page frame) {
        super(gridLocators, frame);
    }

    @Override
    public List<String> getItems() {
        return items.get().stream()
                .map(el -> el.getAttribute("class"))
                .toList();
    }

    @Override
    public String getActiveItem() {
        return items.get().stream()
                .filter(locator -> locator.getAttribute("class").contains("active"))
                .map(locator -> locator.locator("//i"))
                .findFirst()
                .map(locator -> locator.getAttribute("class"))
                .map(attributes -> attributes.replaceAll("nc.*-", ""))
                .orElse(StringUtils.EMPTY);
    }

}
