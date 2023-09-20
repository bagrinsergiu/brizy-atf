package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field;

import com.brizy.io.web.common.dto.element.properties.form.field.type.AbstractFieldProperty;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.FieldLocator;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AbstractRequiredFieldTab extends AbstractFieldTab {

    Supplier<Slider> required;

    public AbstractRequiredFieldTab(FieldLocator field, Frame frame) {
        super(field, frame);
        this.required = () -> new Slider(frame.locator(field.getRequired()));
    }

    @Override
    public void applyProperties(AbstractFieldProperty fieldsProperties) {
        super.applyProperties(fieldsProperties);
        required.get().switchTo(fieldsProperties.isRequired());
    }

}
