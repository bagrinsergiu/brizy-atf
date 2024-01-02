package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.button.size;

import com.brizy.io.web.common.dto.element.properties.button.button.button.size.ButtonSizeProperties;
import com.brizy.io.web.common.dto.element.properties.button.button.button.size.ConcreteSize;
import com.brizy.io.web.common.dto.element.properties.button.button.button.size.CustomSize;
import com.brizy.io.web.common.dto.element.properties.button.button.button.size.SizeTypes;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.tabs.button.size.SizeLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.button.tabs.button.size.custom.CustomLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ButtonSize {

    Supplier<RadioControl<SizeTypes>> size;
    Supplier<NumericInput> width;
    Supplier<NumericInput> height;

    public ButtonSize(SizeLocators size, Frame frame) {
        this.size = () -> new RadioControl<>(SizeTypes.class, size.getItems(), frame);
        CustomLocators customSizeProperties = size.getCustom();
        this.width = () -> new NumericInput(frame.locator(customSizeProperties.getWidth().getValue()));
        this.height = () -> new NumericInput(frame.locator(customSizeProperties.getHeight().getValue()));
    }

    public void applyProperties(ButtonSizeProperties sizeProperties) {
        if (sizeProperties instanceof CustomSize customSize) {
            size.get().set(SizeTypes.CUSTOM);
            width.get().fill(customSize.getWidth());
            height.get().fill(customSize.getHeight());
        } else {
            size.get().set(((ConcreteSize) sizeProperties).getSize());
        }
    }

    public ButtonSizeProperties getProperties() {
        SizeTypes activeSize = size.get().getActiveControl();
        if (activeSize.equals(SizeTypes.CUSTOM)) {
            return CustomSize.builder()
                    .height(Integer.valueOf(height.get().getText()))
                    .width(Integer.valueOf(width.get().getText()))
                    .build();
        }
        return ConcreteSize.builder()
                .size(activeSize)
                .build();
    }

}
