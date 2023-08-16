package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.block;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.block.block.Blocks;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.block.BlockTabLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BlockTab implements IsTab {

    @Getter
    Supplier<Button> tabButton;
    Supplier<Blocks> block;

    public BlockTab(BlockTabLocators blockTabLocators, Frame page) {
        this.block = () -> new Blocks(blockTabLocators.getBlock(), page);
        this.tabButton = () -> new Button(page.locator(blockTabLocators.getSelf()));
    }

    public void applyProperties(Integer block) {
        if (block > 0) {
            open();
            this.block.get().applyProperties(block);
        }
    }

    @Override
    public List<String> getWebConfigurations() {
        return null;
    }

    @Override
    public List<Configuration> getConfigurations() {
        return null;
    }

    public Integer getProperties() {
        open();
        return block.get().getActiveBlock();
    }
}
