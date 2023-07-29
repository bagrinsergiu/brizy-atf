package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Button {

    Locator locator;

    public void click() {
        locator.hover();
        locator.click();
    }

    public String tooltip() {
        return getAttribute("title");
    }

    public Boolean isEnabled() {
        return locator.isEnabled();
    }

    public String getAttribute(String attribute) {
        return locator.getAttribute(attribute);
    }

}
