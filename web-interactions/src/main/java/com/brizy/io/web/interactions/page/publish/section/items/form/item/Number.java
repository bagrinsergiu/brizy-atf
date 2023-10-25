package com.brizy.io.web.interactions.page.publish.section.items.form.item;

import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Number implements FormItem {

    @Getter
    String type;
    @Getter
    String placeHolder;
    Supplier<Locator> elementLocator;

    public Number(Locator elementLocator) {
        this.type = "number";
        this.placeHolder = elementLocator.getAttribute("data-brz-placeholder");
        this.elementLocator = () -> elementLocator;
    }

    public Long getValue() {
        return Long.valueOf(elementLocator.get().inputValue());
    }

    public void setValue(Long content) {
        elementLocator.get().fill(content.toString());
    }

}
