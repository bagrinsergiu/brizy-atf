package com.brizy.io.web.interactions.page.editor.container.components.type.form.type.check_box;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.check_box.new_item.CheckBoxNewItemLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckBoxNewItem {

    Supplier<TextInput> value;
    Supplier<Button> add;

    public CheckBoxNewItem(CheckBoxNewItemLocators newItem, Frame frame) {
        this.value = () -> new TextInput(frame.locator(newItem.getValue()));
        this.add = () -> new Button(frame.locator(newItem.getAddButton()));
    }

    public void addNewOption(String option) {
        value.get().fill(option);
    }

    public void add() {
        add.get().click();
    }

}