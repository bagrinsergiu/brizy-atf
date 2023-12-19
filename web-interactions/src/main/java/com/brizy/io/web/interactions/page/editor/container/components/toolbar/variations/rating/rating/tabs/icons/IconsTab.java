package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.rating.rating.tabs.icons;

import com.brizy.io.web.common.dto.element.properties.rating.rating.icons.IconsTabProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.rating.tabs.icons.IconsTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon.popup.IconPicker;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon.size.IconSize;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IconsTab extends AbstractTabItem {

    Supplier<IconPicker> iconPicker;
    Supplier<IconSize> size;
    Supplier<InputWithUnits> spacing;

    public IconsTab(IconsTabLocators iconsTabLocators, Frame frame) {
        super(iconsTabLocators.getConfigurations(), iconsTabLocators.getSelf(), frame);
        this.iconPicker = () -> new IconPicker(iconsTabLocators.getIcon(), frame);
        this.size = () -> new IconSize(iconsTabLocators.getSize(), frame);
        this.spacing = () -> new InputWithUnits(iconsTabLocators.getSpacing(), frame);
    }

    public void applyProperties(IconsTabProperties iconsTabProperties) {
        open();
        if (Objects.nonNull(iconsTabProperties.getIcon())) {
            iconPicker.get().applyProperties(iconsTabProperties.getIcon());
        }
        if (Objects.nonNull(iconsTabProperties.getSize())) {
            size.get().applyProperties(iconsTabProperties.getSize());
        }
        if (Objects.nonNull(iconsTabProperties.getSpacing())) {
            spacing.get().setValue(iconsTabProperties.getSpacing());
        }
    }

    public IconsTabProperties getProperties() {
        open();
        return IconsTabProperties.builder()
                .size(size.get().getProperties())
                .icon(iconPicker.get().getProperties())
                .spacing(spacing.get().getValue())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        List<Configuration> currentConfigurations = new ArrayList<>() {
            {
                add(Configuration.builder().name(Fields.spacing).element(spacing).build());
                add(Configuration.builder().name("icon picker").element(iconPicker).build());
            }
        };
        currentConfigurations.addAll(size.get().getConfigurations());
        return currentConfigurations;
    }

}
