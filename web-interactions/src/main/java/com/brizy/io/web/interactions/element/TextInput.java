package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class TextInput {

    Locator locator;

    public void fill(String string) {
        locator.fill(string);
    }

    public String getText() {
        return locator.getAttribute("value");
    }

}
