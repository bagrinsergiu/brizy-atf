package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.enumerable;

import com.brizy.io.web.common.dto.element.properties.image.image.align.Enumerable;
import com.brizy.io.web.interactions.element.Button;
import com.microsoft.playwright.Frame;

import java.util.Arrays;
import java.util.function.Supplier;

public class EnumerableButton<E extends Enumerable<E>> {

    Supplier<Button> buttonToClick;
    E[] values;

    public EnumerableButton(E[] values, String locator, Frame frame) {
        this.buttonToClick = () -> new Button(frame.locator(locator));
        this.values = values;
    }

    public void setValue(E value) {
        int counter = 0;
        while (!getValue().equals(value) && counter++ < value.getEnumConstants().length) {
            buttonToClick.get().click();
        }
    }

    public E getValue() {
        String innerHtml = buttonToClick.get().innerHtml();
        return Arrays.stream(values)
                .map(el->el.getEnumByValue(innerHtml))
                .findFirst()
                .orElse(values[0]);
    }

}
