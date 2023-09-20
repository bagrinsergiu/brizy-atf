package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type;

import com.brizy.io.web.common.dto.element.properties.form.field.type.TimeFieldProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.FieldLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field.TimeFieldTab;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TimeField extends AbstractField<TimeFieldProperty> {

    Supplier<TimeFieldTab> fieldTab;

    public TimeField(FieldLocators fieldLocators, Locator elementLocator, Frame frame) {
        super(fieldLocators, frame);
        this.fieldTab = () -> new TimeFieldTab(fieldLocators.getTabs().getField(), frame);
    }

    @Override
    public void applyFieldProperties(TimeFieldProperty fieldProperties) {
        fieldTab.get().applyProperties(fieldProperties);
    }


}
