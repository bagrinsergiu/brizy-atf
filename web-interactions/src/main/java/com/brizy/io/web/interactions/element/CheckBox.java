package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class CheckBox {

    Locator locator;

    public void check() {
        locator.check();
    }

}