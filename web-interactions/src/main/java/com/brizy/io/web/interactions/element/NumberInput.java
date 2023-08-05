package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class NumberInput {

    Locator locator;

    @SneakyThrows
    public void fill(Number value) {
        locator.clear();
        locator.fill(value.toString());
        locator.click();
    }

    public String getText() {
        return locator.getAttribute("value");
    }

}
