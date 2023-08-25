package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.effects;

import com.brizy.io.web.interactions.element.Span;
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

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EffectsGrid extends AbstractGrid {

    Supplier<Span> activeItem;

    public EffectsGrid(GridLocators gridLocators, Page frame) {
        super(gridLocators, frame);
        this.activeItem = () -> new Span(frame.locator(gridLocators.getActiveItem()));
    }

    @Override
    public List<String> getItems() {
        return items.get().stream()
                .map(el -> el.getAttribute("class"))
                .toList();
    }

    @Override
    public String getActiveItem() {
        return activeItem.get().getText();
    }

}
