package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type;

import com.brizy.io.web.common.dto.element.properties.form.field.type.TextFieldProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.FieldLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field.TextFieldTab;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TextField extends AbstractField<TextFieldProperty> {

    Supplier<TextFieldTab> fieldTab;

    public TextField(FieldLocators textFieldTabLocators, Locator locator, Frame frame) {
        super(textFieldTabLocators, frame);
        this.fieldTab = () -> new TextFieldTab(textFieldTabLocators.getTabs().getField(), frame);
    }

    @Override
    public void applyFieldProperties(TextFieldProperty fieldProperty) {
        fieldTab.get().applyProperties(fieldProperty);
    }


}
