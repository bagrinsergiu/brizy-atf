package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.icon.size;

import com.brizy.io.web.common.dto.element.properties.button.button.icon.size.ConcreteSize;
import com.brizy.io.web.common.dto.element.properties.button.button.icon.size.CustomSize;
import com.brizy.io.web.common.dto.element.properties.button.button.icon.size.IconSizes;
import com.brizy.io.web.common.dto.element.properties.button.button.icon.size.Size;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.icon.size.SizeLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class IconSize {

    Supplier<RadioControl<IconSizes>> size;
    Supplier<NumericInput> customSize;

    public IconSize(SizeLocators size, Frame frame) {
        this.size = () -> new RadioControl<>(IconSizes.class, size.getSelf(), frame);
        this.customSize = () -> new NumericInput(frame.locator(size.getCustom().getValue()));
    }

    public void applyProperties(Size size) {
        if (size instanceof CustomSize customSizeProperties) {
            this.size.get().set(IconSizes.CUSTOM);
            this.customSize.get().fill(customSizeProperties.getSize());
        } else {
            this.size.get().set(((ConcreteSize) size).getSize());
        }
    }

    public Size getProperties() {
        IconSizes activeSize = size.get().getActiveControl();
        if (activeSize.equals(IconSizes.CUSTOM)) {
            return CustomSize.builder()
                    .size(Integer.valueOf(customSize.get().getText()))
                    .build();
        }
        return ConcreteSize.builder()
                .size(activeSize)
                .build();
    }

}
