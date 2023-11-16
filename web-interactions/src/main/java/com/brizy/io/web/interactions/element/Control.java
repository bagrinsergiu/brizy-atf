package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Control {

    Locator locator;

    public void click() {
        locator.hover();
        locator.click();
    }

    public boolean isActive() {
        return locator.getAttribute("class").contains("active")
                || locator.getAttribute("class").contains("--active");
    }

}
