package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.colors.gradient;

import com.brizy.io.web.common.dto.element.properties.image.colors.gradient.Color;
import com.brizy.io.web.common.dto.element.properties.image.colors.gradient.Gradient;
import com.brizy.io.web.common.dto.element.properties.image.colors.gradient.Solid;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.colors.tabs.common.AbstractColorWithGradient;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CanHaveGradient {

    Supplier<GradientColor> gradientColor;
    Supplier<SolidColor> solidColor;
    Supplier<ComboBox> colorType;

    public CanHaveGradient(AbstractColorWithGradient colorWithGradient, Frame page) {
        this.colorType = () -> new ComboBox(page.locator(colorWithGradient.getType()));
        this.solidColor = () -> new SolidColor(colorWithGradient, page);
        this.gradientColor = () -> new GradientColor(colorWithGradient, page);
    }

    public void applyColors(Color color) {
        if (color instanceof Solid solid) {
            this.colorType.get().selectItemByValue("Solid");
            this.solidColor.get().applyColor(solid);
        } else if (color instanceof Gradient gradient) {
            this.colorType.get().selectItemByValue("Gradient");
            gradientColor.get().applyGradient(gradient);

        } else {
            colorType.get().selectItemByValue("None");
        }
    }

}