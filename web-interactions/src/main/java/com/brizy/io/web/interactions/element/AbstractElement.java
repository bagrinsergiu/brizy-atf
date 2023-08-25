package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public abstract class AbstractElement {

    Locator locator;

    public Boolean isVisible() {
        return locator.isVisible();
    }

}
