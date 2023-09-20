package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type;

import com.brizy.io.web.common.dto.element.properties.form.field.type.TelFieldProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.FieldLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field.TelFieldTab;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TelField extends AbstractField<TelFieldProperty> {

    Supplier<TelFieldTab> fieldTab;

    public TelField(FieldLocators fieldLocators, Locator elementLocator, Frame frame) {
        super(fieldLocators, frame);
        this.fieldTab = () -> new TelFieldTab(fieldLocators.getTabs().getField(), frame);
    }

    @Override
    public void applyFieldProperties(TelFieldProperty fieldProperty) {
        fieldTab.get().applyProperties(fieldProperty);
    }


}
