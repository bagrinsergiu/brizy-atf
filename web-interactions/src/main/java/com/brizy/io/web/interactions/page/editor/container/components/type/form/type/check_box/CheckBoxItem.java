package com.brizy.io.web.interactions.page.editor.container.components.type.form.type.check_box;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.check_box.item.CheckBoxItemLocators;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckBoxItem {

    Supplier<Button> check;
    Supplier<TextInput> value;
    Supplier<Button> delete;

    public CheckBoxItem(CheckBoxItemLocators checkBoxItemLocators, Locator frame) {
        this.check = () -> new Button(frame.locator(checkBoxItemLocators.getCheck()));
        this.value = () -> new TextInput(frame.locator(checkBoxItemLocators.getValue()));
        this.delete = () -> new Button(frame.locator(checkBoxItemLocators.getDelete()));
    }

    public void deleteItem() {
        delete.get().click();
    }

    public void setValue(String value) {
        this.value.get().fill(value);
    }

    public void check() {
        check.get().click();
    }


}
