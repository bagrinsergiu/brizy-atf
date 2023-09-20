package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type;

import com.brizy.io.web.common.dto.element.properties.form.field.type.HiddenFieldProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.FieldLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field.HiddenFieldTab;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HiddenField extends AbstractField<HiddenFieldProperty> {

    Supplier<HiddenFieldTab> fieldTab;

    public HiddenField(FieldLocators fieldLocators, Locator elementLocator, Frame frame) {
        super(fieldLocators, frame);
        this.fieldTab = () -> new HiddenFieldTab(fieldLocators.getTabs().getField(), frame);
    }

    @Override
    public void applyFieldProperties(HiddenFieldProperty fieldProperty) {
        fieldTab.get().applyProperties(fieldProperty);
    }


}
