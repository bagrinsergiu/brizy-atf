package com.brizy.io.web.interactions.element.composite;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import com.brizy.io.web.interactions.element.Button;
import com.microsoft.playwright.Frame;

import java.util.Arrays;
import java.util.function.Supplier;

public class EnumerableButton<E extends Enum<E> & Enumerable<E>> {

    Supplier<Button> buttonToClick;
    Class<E> clazz;

    public EnumerableButton(Class<E> clazz, String locator, Frame frame) {
        this.buttonToClick = () -> new Button(frame.locator(locator));
        this.clazz = clazz;
    }

    public void setValue(E value) {
        int counter = 0;
        while (!getValue().equals(value) && counter++ < value.getValues().length) {
            buttonToClick.get().click();
        }
    }

    public E getValue() {
        String innerHtml = buttonToClick.get().innerHtml();
        return Arrays.stream(clazz.getEnumConstants())
                .filter(el -> innerHtml.contains(el.getValue()))
                .findFirst()
                .orElseThrow();
    }

}
