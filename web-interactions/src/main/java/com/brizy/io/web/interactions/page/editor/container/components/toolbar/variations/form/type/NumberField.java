package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type;

import com.brizy.io.web.common.dto.element.properties.form.field.type.NumberFieldProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.FieldLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field.NumberFieldTab;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NumberField extends AbstractField<NumberFieldProperty> {

    Supplier<NumberFieldTab> fieldTab;

    public NumberField(FieldLocators textFieldTabLocators, Locator elementLocator, Frame frame) {
        super(textFieldTabLocators, frame);
        this.fieldTab = () -> new NumberFieldTab(textFieldTabLocators.getTabs().getField(), frame);
    }

    @Override
    public void applyFieldProperties(NumberFieldProperty fieldProperties) {
        fieldTab.get().applyProperties(fieldProperties);
    }


}
