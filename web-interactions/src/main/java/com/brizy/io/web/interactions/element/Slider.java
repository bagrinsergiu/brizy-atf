package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class Slider extends AbstractElement {

    public Slider(Locator locator) {
        super(locator);
    }

    public void switchTo(Boolean state) {
        if (!state.equals(getState())) {
            locator.click();
        }
    }

    public Boolean getState() {
        if (isVisible()) {
            return locator.getAttribute("class").contains("on");
        }
        return null;
    }

}
