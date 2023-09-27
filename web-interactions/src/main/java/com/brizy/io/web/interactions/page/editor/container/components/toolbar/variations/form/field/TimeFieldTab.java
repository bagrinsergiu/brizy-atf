package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field;

import com.brizy.io.web.common.dto.element.properties.form.field.type.TimeFieldProperty;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.FieldLocator;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TimeFieldTab extends AbstractNativeHtmlFiveFieldTab {

    Supplier<TextInput> maxTime;
    Supplier<TextInput> minTime;

    public TimeFieldTab(FieldLocator field, Frame frame) {
        super(field, frame);
        this.maxTime = () -> new TextInput(frame.locator(field.getMaxTime()));
        this.minTime = () -> new TextInput(frame.locator(field.getMinTime()));
    }

    public void applyProperties(TimeFieldProperty fieldsProperties) {
        super.applyProperties(fieldsProperties);
        if (Objects.nonNull(fieldsProperties.getConfiguration())) {
            var configuration = fieldsProperties.getConfiguration();
            if (Objects.nonNull(configuration.getMaxTime())) {
                maxTime.get().fill(configuration.getMaxTime());
            }
            if (Objects.nonNull(configuration.getMinTime())) {
                minTime.get().fill(configuration.getMinTime());
            }
        }
    }
}
