package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.block.block;

import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.block.BlockLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Blocks {

    Supplier<List<Locator>> blocks;

    public Blocks(BlockLocators blockLocators, Frame frame) {
        this.blocks = () -> frame.locator(blockLocators.getItems()).all();
    }

    public void applyProperties(Integer block) {
        blocks.get().get(block - 1).click();
    }

    public Integer getActiveBlock() {
        Locator locator = blocks.get().stream()
                .filter(el -> el.getAttribute("class").contains("active"))
                .findFirst()
                .orElse(null);
        return blocks.get().indexOf(locator) + 1;
    }

}
