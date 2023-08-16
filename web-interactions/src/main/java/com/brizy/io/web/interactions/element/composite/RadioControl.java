package com.brizy.io.web.interactions.element.composite;

import com.brizy.io.web.common.dto.element.properties.common.Enumerable;
import com.brizy.io.web.interactions.element.Button;
import com.microsoft.playwright.Frame;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class RadioControl<E extends Enum<E> & Enumerable<E>> {

    Supplier<Map<E, Button>> controls;
    Class<E> clazz;

    public RadioControl(Class<E> clazz, String locator, Frame frame) {
        this.controls = () -> initializeControls(locator, frame);
        this.clazz = clazz;
    }

    private Map<E, Button> initializeControls(String locator, Frame frame) {
        return frame.locator(locator).all().stream()
                .map(buttonLocator -> Pair.of(getEnumByInnerHtmlValue(buttonLocator.innerHTML()), new Button(buttonLocator)))
                .collect(HashMap::new, (map, pair) -> map.put(pair.getKey(), pair.getValue()), HashMap::putAll);
    }

    private E getEnumByInnerHtmlValue(String innerHtmlValue) {
        return Arrays.stream(clazz.getEnumConstants())
                .filter(e -> innerHtmlValue.contains(e.getValue()))
                .findFirst()
                .orElseThrow();
    }

    public void set(E enumToSet) {
        controls.get().get(enumToSet).click();
    }

}
