package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.gallery.pop_up.tabs.items;

import com.brizy.io.web.common.dto.element.properties.gallery.pop_up.tabs.items.ItemsTabProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.gallery.tabs.items.ItemsTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ItemsTab extends AbstractTabItem {

    Supplier<InputWithUnits> columns;
    Supplier<InputWithUnits> spacing;

    public ItemsTab(ItemsTabLocators itemsTabLocators, Frame frame) {
        super(itemsTabLocators.getConfigurations(), itemsTabLocators.getSelf(), frame);
        this.columns = () -> new InputWithUnits(itemsTabLocators.getColumns(), frame);
        this.spacing = () -> new InputWithUnits(itemsTabLocators.getSpacing(), frame);
    }

    public void applyProperties(ItemsTabProperties itemsTabProperties) {
        open();
        if (Objects.nonNull(itemsTabProperties.getColumns())) {
            columns.get().setValue(itemsTabProperties.getColumns());
        }
        if (Objects.nonNull(itemsTabProperties.getSpacing())) {
            spacing.get().setValue(itemsTabProperties.getSpacing());
        }
    }

    public ItemsTabProperties getProperties() {
        open();
        return ItemsTabProperties.builder()
                .columns(columns.get().getValue())
                .spacing(spacing.get().getValue())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.columns).element(columns).build(),
                Configuration.builder().name(Fields.spacing).element(spacing).build()
        );
    }

}
