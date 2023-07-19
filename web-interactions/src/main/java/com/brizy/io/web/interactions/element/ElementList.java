package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ElementList {

    Locator locator;

    public void pickItem(String string) {
        locator.filter(new Locator.FilterOptions().setHasText(string)).click();
    }

    public java.util.List<String> getItems() {
        return locator.getByRole(AriaRole.LISTITEM).all().stream()
                .map(Locator::textContent)
                .collect(Collectors.toList());
    }

}
