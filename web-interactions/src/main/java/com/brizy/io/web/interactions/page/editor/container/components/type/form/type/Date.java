package com.brizy.io.web.interactions.page.editor.container.components.type.form.type;

import com.brizy.io.web.common.dto.element.properties.form.FormProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.type.DateFieldProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.AbstractField;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.DateField;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.field.factory.FormField;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.toolbar.FormToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Date implements FormField<DateFieldProperty> {

    Locator elementLocator;
    DateFieldToolbar toolbar;
    FormProperties formProperties;

    public Date(ItemLocators itemLocators, FormProperties formProperties, Frame frame, Locator elementLocator) {
        this.formProperties = formProperties;
        this.elementLocator = elementLocator;
        var toolbarLocators = itemLocators.getToolbar();
        this.toolbar = new DateFieldToolbar(toolbarLocators, elementLocator, frame);
    }

    @Override
    public void setToolbarProperties(DateFieldProperty properties) {
        elementLocator.click();
        toolbar.setProperties(properties);
    }

    @Override
    public void configureFormField(DateFieldProperty properties) {
        var placeholder = properties.getPlaceholder();
        elementLocator.locator("//input").fill(placeholder);
    }

    @Override
    public void duplicate() {
        toolbar.duplicate();
    }

    @Override
    public void delete() {
        toolbar.delete();
    }

    protected class DateFieldToolbar extends FormToolbar<DateFieldProperty> {

        Supplier<DateField> dateField;

        public DateFieldToolbar(ToolbarLocators toolbar, Locator elementLocator, Frame frame) {
            super(toolbar, frame);
            this.dateField = () -> new DateField(toolbar.getField(), elementLocator, frame);
        }

        @Override
        public void setProperties(FormProperties properties) {
            super.setProperties(properties);
        }

        @Override
        public AbstractField<DateFieldProperty> getField() {
            return dateField.get();
        }

        /**
         * This method was implemented to have a distinction between different fields, but, in the end,
         * the method from the superclass is called with some refactored DTO, because we have shared settings
         * of the form across all the field elements.
         *
         * @param dateFieldProperty - properties for the date field
         */
        @Override
        public void setProperties(DateFieldProperty dateFieldProperty) {
            super.setProperties(formProperties.toBuilder()
                    .field(formProperties.getField().toBuilder()
                            .fields(List.of(dateFieldProperty))
                            .build()
                    )
                    .build());
        }

    }

}
