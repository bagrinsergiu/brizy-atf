package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.button;

import com.brizy.io.web.common.dto.element.properties.button.button.button.ButtonTabProperties;
import com.brizy.io.web.common.dto.element.properties.button.button.button.fill.FillTypes;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.tabs.button.ButtonLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.button.corner.Corner;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.button.size.ButtonSize;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ButtonTab extends AbstractTabItem {

    Supplier<ButtonSize> size;
    Supplier<RadioControl<FillTypes>> fill;
    Supplier<Corner> corner;

    public ButtonTab(ButtonLocators buttonLocators, Frame frame) {
        super(buttonLocators.getConfigurations(), buttonLocators.getSelf(), frame);
        this.size = () -> new ButtonSize(buttonLocators.getSize(), frame);
        this.fill = () -> new RadioControl<>(FillTypes.class, buttonLocators.getFill(), frame);
        this.corner = () -> new Corner(buttonLocators.getCorner(), frame);
    }

    public void applyProperties(ButtonTabProperties propertiesToApply) {
        open();
        size.get().applyProperties(propertiesToApply.getSize());
        fill.get().set(propertiesToApply.getFill());
        corner.get().applyProperties(propertiesToApply.getCorner());
    }

    public ButtonTabProperties getProperties() {
        open();
        return ButtonTabProperties.builder()
                .corner(corner.get().getProperties())
                .fill(fill.get().getActiveControl())
                .size(size.get().getProperties())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.corner).element(corner).build(),
                Configuration.builder().name(Fields.fill).element(fill).build(),
                Configuration.builder().name(Fields.size).element(size).build()
        );
    }

    public ButtonTabProperties getProperties() {
        open();
        return ButtonTabProperties.builder()
                .corner(corner.get().getProperties())
                .fill(fill.get().getActiveControl())
                .size(size.get().getProperties())
                .build();
    }

}
