package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class TextInput implements Input {

    Locator locator;

    @SneakyThrows
    public void fill(String string) {
        locator.clear();
        locator.fill(string);
        locator.click();
    }

    @Override
    public String getRawValue() {
        return locator.getAttribute("value");
    }

}
