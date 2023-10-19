package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field;

import com.brizy.io.web.common.dto.element.properties.form.field.type.DateFieldProperty;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.FieldLocator;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DateFieldTab extends AbstractNativeHtmlFiveFieldTab {

    Supplier<TextInput> maxDate;
    Supplier<TextInput> minDate;

    public DateFieldTab(FieldLocator field, Frame frame) {
        super(field, frame);
        this.maxDate = () -> new TextInput(frame.locator(field.getMaxDate()));
        this.minDate = () -> new TextInput(frame.locator(field.getMinDate()));
    }

    public void applyProperties(DateFieldProperty fieldsProperties) {
        super.applyProperties(fieldsProperties);
        if (Objects.nonNull(fieldsProperties.getConfiguration())) {
            var configuration = fieldsProperties.getConfiguration();
            if (Objects.nonNull(configuration.getMaxDate())) {
                maxDate.get().fill(configuration.getMaxDate());
            }
            if (Objects.nonNull(configuration.getMinDate())) {
                minDate.get().fill(configuration.getMinDate());
            }
        }
    }

}
