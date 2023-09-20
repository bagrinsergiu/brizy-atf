package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type;

import com.brizy.io.web.common.dto.element.properties.form.field.type.SelectFieldProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.FieldLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field.SelectFieldTab;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SelectField extends AbstractField<SelectFieldProperty> {

    Supplier<SelectFieldTab> fieldTab;

    public SelectField(FieldLocators fieldLocators, Locator elementLocator, Frame frame) {
        super(fieldLocators, frame);
        this.fieldTab = () -> new SelectFieldTab(fieldLocators.getTabs().getField(), frame);
    }

    @Override
    public void applyFieldProperties(SelectFieldProperty fieldProperty) {
        fieldTab.get().applyProperties(fieldProperty);
    }


}
