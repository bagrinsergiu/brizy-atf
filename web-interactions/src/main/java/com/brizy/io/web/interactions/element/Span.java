package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Span extends AbstractElement implements Element {

    public Span(Locator locator) {
        super(locator);
    }

    public void click() {
        locator.click();
    }

    public boolean isDisplayed() {
        return locator.isVisible();
    }

}