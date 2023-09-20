package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field;

import com.brizy.io.web.common.dto.element.properties.form.field.type.NumberFieldProperty;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.FieldLocator;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NumberFieldTab extends AbstractRequiredFieldTab {

    Supplier<TextInput> max;
    Supplier<TextInput> maxNumberErrorMessage;
    Supplier<TextInput> min;
    Supplier<TextInput> minNumberErrorMessage;

    public NumberFieldTab(FieldLocator field, Frame frame) {
        super(field, frame);
        this.max = () -> new TextInput(frame.locator(field.getMax()));
        this.maxNumberErrorMessage = () -> new TextInput(frame.locator(field.getMaxNumberErrorMessage()));
        this.min = () -> new TextInput(frame.locator(field.getMin()));
        this.minNumberErrorMessage = () -> new TextInput(frame.locator(field.getMinNumberErrorMessage()));
    }

    public void applyProperties(NumberFieldProperty fieldsProperties) {
        super.applyProperties(fieldsProperties);
        if (Objects.nonNull(fieldsProperties.getConfiguration())) {
            var configuration = fieldsProperties.getConfiguration();
            if (Objects.nonNull(configuration.getMaxNumber())) {
                max.get().fill(String.valueOf(configuration.getMaxNumber()));
            }
            if (Objects.nonNull(configuration.getMinNumber())) {
                min.get().fill(String.valueOf(configuration.getMinNumber()));
            }
            if (Objects.nonNull(configuration.getErrorMessage())) {
                var errorMessage = configuration.getErrorMessage();
                if (Objects.nonNull(errorMessage.getMaxNumber())) {
                    maxNumberErrorMessage.get().fill(String.valueOf(errorMessage.getMaxNumber()));
                }
                if (Objects.nonNull(errorMessage.getMinNumber())) {
                    minNumberErrorMessage.get().fill(String.valueOf(errorMessage.getMinNumber()));
                }
            }
        }
    }

}
