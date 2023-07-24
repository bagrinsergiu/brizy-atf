package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ComboBox {

    Locator locator;

    private void open() {
        locator.click();
    }

    public void selectItem(String itemName) {
        open();
        Locator byText = locator.getByRole(AriaRole.OPTION,  new Locator.GetByRoleOptions().setName(itemName).setExact(true));
        byText.scrollIntoViewIfNeeded();
        byText.click();
    }

    public List<String> items() {
        open();
        return locator.getByRole(AriaRole.OPTION).all()
                .stream()
                .map(Locator::textContent)
                .collect(Collectors.toList());
    }

    public String getSelectedItem() {
        return locator.textContent();
    }

}
