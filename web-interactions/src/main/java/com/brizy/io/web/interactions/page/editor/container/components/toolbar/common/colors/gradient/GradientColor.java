package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.colors.gradient;

import com.brizy.io.web.common.dto.element.properties.image.colors.gradient.Gradient;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.colors.tabs.common.AbstractColorWithGradient;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GradientColor {

    Supplier<TextInput> color;
    Supplier<ComboBox> gradientType;
    Supplier<NumericInput> gradientAngle;

    public GradientColor(AbstractColorWithGradient gradientColorProperties, Frame page) {
        this.color = () -> new TextInput(page.locator(gradientColorProperties.getValue()));
        this.gradientType = () -> new ComboBox(page.locator(gradientColorProperties.getGradientType()));
        this.gradientAngle = () -> new NumericInput(page.locator(gradientColorProperties.getAngle()));
    }

    public void applyGradient(Gradient gradient) {
        this.color.get().fill(gradient.getColor());
        this.gradientType.get().selectItemByValue(gradient.getGradientType().name());
        this.gradientAngle.get().fill(gradient.getAngle());
    }

}
