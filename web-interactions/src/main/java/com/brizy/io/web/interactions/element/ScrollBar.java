package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ScrollBar {

    Locator locator;

    public void selectItem(String itemName) {
        Locator foundItem = locator.getByText(itemName);
        foundItem.scrollIntoViewIfNeeded();
        foundItem.click();
    }

}
