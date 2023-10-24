package com.brizy.io.web.interactions.page.publish.section.items.form.item;

import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Text implements FormItem {

    @Getter
    String type;
    @Getter
    String placeHolder;
    Supplier<Locator> elementLocator;

    public Text(Locator elementLocator) {
        this.type = "text";
        this.placeHolder = elementLocator.getAttribute("data-brz-placeholder");
        this.elementLocator = () -> elementLocator;
    }

    public String getContent() {
        return elementLocator.get().inputValue();
    }

    public void setContent(String content) {
        elementLocator.get().fill(content);
    }

}
