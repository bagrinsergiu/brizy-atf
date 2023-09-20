package com.brizy.io.web.interactions.page.editor.container.components.type.form.type.select;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.select.item.SelectItemLocators;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SelectItem {

    Supplier<TextInput> value;
    Supplier<Button> delete;

    public SelectItem(SelectItemLocators checkBoxItemLocators, Locator locator) {
        this.value = () -> new TextInput(locator.locator(checkBoxItemLocators.getValue()));
        this.delete = () -> new Button(locator.locator(checkBoxItemLocators.getDelete()));
    }

    public void deleteItem() {
        delete.get().click();
    }

    public void setValue(String value) {
        this.value.get().fill(value);
    }

}
