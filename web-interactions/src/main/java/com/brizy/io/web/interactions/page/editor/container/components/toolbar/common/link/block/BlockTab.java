package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.link.block;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.link.tabs.block.BlockTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.link.block.block.Blocks;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BlockTab extends AbstractTabItem {

    Supplier<Blocks> block;

    public BlockTab(BlockTabLocators blockTabLocators, Frame frame) {
        super(blockTabLocators.getConfigurations(), blockTabLocators.getSelf(), frame);
        this.block = () -> new Blocks(blockTabLocators.getBlock(), frame);
    }

    public void applyProperties(Integer block) {
        if (block > 0) {
            open();
            this.block.get().applyProperties(block);
        }
    }

    public Integer getProperties() {
        open();
        return block.get().getActiveBlock();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.block).element(block).build()
        );
    }

    public Integer getProperties() {
        open();
        return block.get().getActiveBlock();
    }
}
