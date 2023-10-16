package com.brizy.io.web.interactions.page.publish.section.items.form.item;

import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Select implements FormItem {

    @Getter
    String type;
    @Getter
    String placeHolder;
    Supplier<List<String>> items;
    Supplier<Locator> elementLocator;

    public Select(Locator elementLocator) {
        this.type = "select";
        this.placeHolder = elementLocator.getAttribute("data-brz-placeholder");
        this.items = () -> elementLocator.locator("//option").all()
                .stream()
                .map(Locator::textContent)
                .toList();
        this.elementLocator = () -> elementLocator;
    }

    public List<String> getItems() {
        return items.get();
    }

    public void selectItem(String item) {
        elementLocator.get().selectOption(item);
    }

    public String getSelectedItem() {
        return elementLocator.get().textContent();
    }

}
