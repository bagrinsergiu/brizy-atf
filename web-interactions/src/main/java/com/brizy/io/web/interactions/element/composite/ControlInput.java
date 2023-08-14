package com.brizy.io.web.interactions.element.composite;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.typography.styles.common.ValueProperties;
import com.microsoft.playwright.Frame;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ControlInput {

    Supplier<NumericInput> value;
    Supplier<Button> increase;
    Supplier<Button> decrease;

    public ControlInput(ValueProperties properties, Frame frame) {
        this.value = () -> new NumericInput(frame.locator(properties.getValue()));
        this.increase = () -> new Button(frame.locator(properties.getIncrease()));
        this.decrease = () -> new Button(frame.locator(properties.getDecrease()));
    }

    public void fill(Double number) {
        value.get().fill(number);
    }

    public void fillWithControls(Double number) {
        Button buttonToPress;
        if (value().equals(number)) {
            return;
        } else if (value() > number) {
            buttonToPress = decrease.get();
        } else {
            buttonToPress = increase.get();
        }
//        TODO refactor with timeout, in case of for example 1 minute elapsed ski[
        while (!value().equals(number)) {
            buttonToPress.click();
        }
    }

    public Double value() {
        String rawValue = value.get().getText();
        return Double.parseDouble(rawValue);
    }

}
