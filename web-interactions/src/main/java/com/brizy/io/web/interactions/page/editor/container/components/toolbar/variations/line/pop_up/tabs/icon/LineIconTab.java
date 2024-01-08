package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.line.pop_up.tabs.icon;

import com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.common.LineAlign;
import com.brizy.io.web.common.dto.element.properties.line.pop_up.tabs.icon.IconTabProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.line.tabs.icon.IconTabLocators;
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
public class LineIconTab extends AbstractTabItem {

    Supplier<IconPicker> iconPicker;
    Supplier<RadioControl<LineAlign>> align;
    Supplier<IconSize> size;
    Supplier<InputWithUnits> spacing;
    Supplier<InputWithUnits> padding;
    Supplier<InputWithUnits> rotate;

    public LineIconTab(IconTabLocators lineTabLocators, Frame frame) {
        super(lineTabLocators.getConfigurations(), lineTabLocators.getSelf(), frame);
        this.iconPicker = () -> new IconPicker(lineTabLocators.getIcon(), frame);
        this.align = () -> new RadioControl<>(LineAlign.class, lineTabLocators.getAlign(), frame);
        this.size = () -> new IconSize(lineTabLocators.getSize(), frame);
        this.padding = () -> new InputWithUnits(lineTabLocators.getPadding(), frame);
        this.rotate = () -> new InputWithUnits(lineTabLocators.getRotate(), frame);
        this.spacing = () -> new InputWithUnits(lineTabLocators.getSpacing(), frame);
    }

    public void applyProperties(IconTabProperties lineTabProperties) {
        open();
        if (Objects.nonNull(lineTabProperties.getIcon())) {
            iconPicker.get().applyProperties(lineTabProperties.getIcon());
        }
        if (Objects.nonNull(lineTabProperties.getAlign())) {
            align.get().set(lineTabProperties.getAlign());
        }
        if (Objects.nonNull(lineTabProperties.getSize())) {
            size.get().applyProperties(lineTabProperties.getSize());
        }
        if (Objects.nonNull(lineTabProperties.getSpacing())) {
            spacing.get().setValue(lineTabProperties.getSpacing());
        }
        if (Objects.nonNull(lineTabProperties.getPadding())) {
            padding.get().setValue(lineTabProperties.getPadding());
        }
        if (Objects.nonNull(lineTabProperties.getRotate())) {
            rotate.get().setValue(lineTabProperties.getRotate());
        }
    }

    public IconTabProperties getProperties() {
        open();
        return IconTabProperties.builder()
                .icon(iconPicker.get().getProperties())
                .align(align.get().getActiveControl())
                .size(size.get().getProperties())
                .spacing(spacing.get().getValue())
                .padding(padding.get().getValue())
                .rotate(rotate.get().getValue())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.align).element(align).build(),
                Configuration.builder().name(Fields.padding).element(padding).build(),
                Configuration.builder().name(Fields.rotate).element(rotate).build(),
                Configuration.builder().name(Fields.size).element(size).build(),
                Configuration.builder().name(Fields.spacing).element(spacing).build(),
                Configuration.builder().name("icon picker").element(iconPicker).build()
        );
    }

}
