package com.brizy.io.web.interactions.page.editor.container.components.toolbar.colors;

import com.brizy.io.web.common.dto.element.properties.toolbar.colors.Colors;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.border.BorderProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Border implements CustomizableColor {

    Supplier<TextInput> color;
    Supplier<TextInput> size;

    public Border(BorderProperties border, Frame page) {
        this.color = () -> new TextInput(page.locator(border.getColor()));
        this.size = () -> new TextInput(page.locator(border.getSize()));
    }

    @Override
    public void with(Colors property) {
        String colorToSet = property.getBorder().getColor();
        Integer sizeToSet = property.getBorder().getSize();
        if (Objects.nonNull(colorToSet)) {
            color.get().fill(colorToSet);
        }
        if (Objects.nonNull(sizeToSet)) {
            size.get().fill(sizeToSet.toString());
        }
    }
}
