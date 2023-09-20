package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field;

import com.brizy.io.web.common.dto.element.properties.form.field.type.AbstractFieldProperty;
import com.brizy.io.web.common.dto.element.properties.form.field.type.SelectFieldProperty;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.FieldLocator;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SelectFieldTab extends AbstractRequiredFieldTab {

    Slider multipleSelection;

    public SelectFieldTab(FieldLocator fieldLocators, Frame frame) {
        super(fieldLocators, frame);
        this.multipleSelection = new Slider(frame.locator(fieldLocators.getMultipleSelection()));
    }

    @Override
    public void applyProperties(AbstractFieldProperty fieldsProperties) {
        super.applyProperties(fieldsProperties);
        var selectFieldProperty = (SelectFieldProperty) fieldsProperties;
        this.multipleSelection.switchTo(selectFieldProperty.isMultipleSelection());
    }

}
