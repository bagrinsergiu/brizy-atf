package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.map.colors;

import com.brizy.io.web.common.dto.element.properties.common.colors.border.CanHaveBorders;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.CustomizableColor;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.border.BorderProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Border implements CustomizableColor {

    Supplier<TextInput> color;
    Supplier<NumericInput> size;

    public Border(BorderProperties border, Frame page) {
        this.color = () -> new TextInput(page.locator(border.getValue()));
        this.size = () -> new NumericInput(page.locator(border.getSize()));
    }

    @Override
    public void with(CanHaveBorders property) {
        String colorToSet = property.getBorder().getColor();
//        TODO refactor
//        Integer sizeToSet = property.getBorder().getSize();
        if (Objects.nonNull(colorToSet)) {
            color.get().fill(colorToSet);
        }
//        if (Objects.nonNull(sizeToSet)) {
//            size.get().fill(sizeToSet);
//        }
    }

    public void applyProperties(com.brizy.io.web.common.dto.element.properties.common.colors.border.Border properties) {
        String colorToSet = properties.getColor();
//        TODO refactor
//        Integer sizeToSet = properties.getSize();
        if (Objects.nonNull(colorToSet)) {
            color.get().fill(colorToSet);
        }
//        if (Objects.nonNull(sizeToSet)) {
//            size.get().fill(sizeToSet);
//        }
    }

}
