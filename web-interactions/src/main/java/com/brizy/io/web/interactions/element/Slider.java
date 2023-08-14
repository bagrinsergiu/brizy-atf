package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Slider {

    Locator locator;

    public void switchTo(Boolean state) {
        if (getState().equals(state))
            return;
        locator.click();
    }

    public Boolean getState() {
        return locator.getAttribute("class").contains("active");
    }

}
