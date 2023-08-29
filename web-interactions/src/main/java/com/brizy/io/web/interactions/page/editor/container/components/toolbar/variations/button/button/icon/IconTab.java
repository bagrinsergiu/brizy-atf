package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon;

import com.brizy.io.web.common.dto.element.properties.button.button.icon.IconTabProperties;
import com.brizy.io.web.common.dto.element.properties.button.button.icon.align.IconAligns;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.tabs.icon.IconLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon.popup.IconPicker;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon.size.IconSize;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IconTab extends AbstractTabItem {

    Supplier<IconPicker> iconPicker;
    Supplier<RadioControl<IconAligns>> position;
    Supplier<IconSize> size;
    Supplier<NumericInput> spacing;

    public IconTab(IconLocators iconLocators, Frame frame) {
        super(iconLocators.getConfigurations(), iconLocators.getSelf(), frame);
        this.iconPicker = () -> new IconPicker(iconLocators.getIcon(), frame);
        this.position = () -> new RadioControl<>(IconAligns.class, iconLocators.getPosition(), frame);
        this.size = () -> new IconSize(iconLocators.getSize(), frame);
        this.spacing = () -> new NumericInput(frame.locator(iconLocators.getSpacing().getValue()));
    }

    public void applyProperties(IconTabProperties propertiesToApply) {
        open();
        if (Objects.nonNull(propertiesToApply.getIcon())) {
            iconPicker.get().applyProperties(propertiesToApply.getIcon());
        }
        if (Objects.nonNull(propertiesToApply.getAlign())) {
            position.get().set(propertiesToApply.getAlign());
        }
        if (Objects.nonNull(propertiesToApply.getSize())) {
            size.get().applyProperties(propertiesToApply.getSize());
        }
        if (Objects.nonNull(propertiesToApply.getSpacing())) {
            spacing.get().fill(propertiesToApply.getSpacing());
        }
    }

    public IconTabProperties getProperties() {
        open();
        return IconTabProperties.builder()
                .icon(iconPicker.get().getProperties())
                .align(position.get().getActiveControl())
                .size(size.get().getProperties())
                .spacing(Integer.valueOf(spacing.get().getText()))
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.iconPicker).element(iconPicker).build(),
                Configuration.builder().name(Fields.position).element(position).build(),
                Configuration.builder().name(Fields.size).element(size).build(),
                Configuration.builder().name(Fields.spacing).element(spacing).build()
        );
    }

}
