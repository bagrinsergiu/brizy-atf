package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.colors.gradient;

import com.brizy.io.web.common.dto.element.properties.image.colors.gradient.Solid;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.common.AbstractColor;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SolidColor {

    Supplier<TextInput> color;

    public SolidColor(AbstractColor solidColorProperties, Frame page) {
        this.color = () -> new TextInput(page.locator(solidColorProperties.getValue()));
    }

    public void applyColor(Solid solid) {
        this.color.get().fill(solid.getColor());
    }

}
