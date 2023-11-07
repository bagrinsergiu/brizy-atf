package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.icon.icon;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon.popup.IconPicker;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon.size.IconSize;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class IconTab extends AbstractTabItem {

    Supplier<IconPicker> iconPicker;
    Supplier<IconSize> size;

    public IconTab(com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.icon.tabs.icon.IconLocators iconLocators, Frame frame) {
        super(iconLocators.getConfigurations(), iconLocators.getSelf(), frame);
        this.iconPicker = () -> new IconPicker(iconLocators.getIcon(), frame);
        this.size = () -> new IconSize(iconLocators.getSize(), frame);
    }

    public void applyProperties(com.brizy.io.web.common.dto.element.properties.icon.tabs.icon.IconTabProperties propertiesToApply) {
        open();
        if (Objects.nonNull(propertiesToApply.getIcon())) {
            iconPicker.get().applyProperties(propertiesToApply.getIcon());
        }
        if (Objects.nonNull(propertiesToApply.getSize())) {
            size.get().applyProperties(propertiesToApply.getSize());
        }
    }

    public com.brizy.io.web.common.dto.element.properties.icon.tabs.icon.IconTabProperties getProperties() {
        open();
        return com.brizy.io.web.common.dto.element.properties.icon.tabs.icon.IconTabProperties.builder()
                .icon(iconPicker.get().getProperties())
                .size(size.get().getProperties())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        var configurations = new ArrayList<Configuration>() {{
            add(Configuration.builder().name(Fields.iconPicker).element(iconPicker).build());
        }};
        var itemsWereAdded = configurations.addAll(size.get().getConfigurations());
        log.debug("Items from complex corner element were added {}", itemsWereAdded);
        return configurations;
    }

}
