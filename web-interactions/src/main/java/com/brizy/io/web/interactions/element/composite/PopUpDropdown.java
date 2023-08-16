package com.brizy.io.web.interactions.element.composite;

import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.common.DropDownLocators;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class PopUpDropdown {

    Supplier<Locator> openerButton;
    Supplier<Locator> dropDownItems;

    public PopUpDropdown(DropDownLocators dropDownLocators, Page frame) {
        this.openerButton = () -> frame.locator(dropDownLocators.getSelf());
        this.dropDownItems = () -> frame.locator(dropDownLocators.getItems());
    }

    public void selectItem(String item) {
        if (!item.isBlank() && !item.isEmpty()) {
            openDropDown();
            dropDownItems.get().all().stream()
                    .filter(el -> el.textContent().equals(item))
                    .findFirst()
                    .ifPresent(Locator::click);
        }
    }

    private void openDropDown() {
        openerButton.get().click();
    }

    public String getActiveItem() {
        return openerButton.get().textContent();
    }

    public List<String> getItems() {
        openDropDown();
        return dropDownItems.get().all().stream()
                .map(Locator::textContent)
                .toList();
    }

}
