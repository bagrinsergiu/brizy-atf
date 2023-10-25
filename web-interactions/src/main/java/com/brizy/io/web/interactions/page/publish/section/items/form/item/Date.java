package com.brizy.io.web.interactions.page.publish.section.items.form.item;

import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Date implements FormItem {

    @Getter
    String type;
    @Getter
    String placeHolder;
    Supplier<Locator> elementLocator;

    public Date(Locator elementLocator) {
        this.type = "date";
        this.placeHolder = elementLocator.getAttribute("data-brz-placeholder");
        this.elementLocator = () -> elementLocator;
    }

    public LocalDate getContent() {
        return LocalDate.parse(elementLocator.get().inputValue());
    }

    public void setContent(LocalDate content) {
        elementLocator.get().fill(content.toString());
    }

}
