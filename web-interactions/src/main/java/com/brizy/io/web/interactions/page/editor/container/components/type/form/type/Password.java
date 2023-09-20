package com.brizy.io.web.interactions.page.editor.container.components.type.form.type;

import com.brizy.io.web.common.dto.element.properties.form.FormProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.type.PasswordFieldProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.FormToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.AbstractField;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.PasswordField;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.field.factory.FormField;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Password implements FormField<PasswordFieldProperty> {

    Locator elementLocator;
    PasswordFieldToolbar toolbar;
    FormProperties formProperties;

    public Password(ItemLocators itemLocators, FormProperties formProperties, Frame frame, Locator elementLocator) {
        this.formProperties = formProperties;
        this.elementLocator = elementLocator;
        var toolbarLocators = itemLocators.getToolbar();
        this.toolbar = new PasswordFieldToolbar(toolbarLocators, elementLocator, frame);
    }

    @Override
    public void setToolbarProperties(PasswordFieldProperty properties) {
        elementLocator.click();
        toolbar.setProperties(properties);
    }

    @Override
    public void configureFormField(PasswordFieldProperty properties) {
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

    protected class PasswordFieldToolbar extends FormToolbar<PasswordFieldProperty> {

        Supplier<PasswordField> passwordField;

        public PasswordFieldToolbar(ToolbarLocators toolbar, Locator elementLocator, Frame frame) {
            super(toolbar, frame);
            this.passwordField = () -> new PasswordField(toolbar.getField(), elementLocator, frame);
        }

        @Override
        public void setProperties(FormProperties properties) {
            super.setProperties(properties);
        }

        @Override
        public AbstractField<PasswordFieldProperty> getField() {
            return passwordField.get();
        }

        /**
         * This method was implemented to have a distinction between different fields, but, in the end,
         * the method from the superclass is called with some refactored DTO, because we have shared settings
         * of the form across all the field elements.
         *
         * @param passwordFieldProperty - properties for the password field
         */
        @Override
        public void setProperties(PasswordFieldProperty passwordFieldProperty) {
            super.setProperties(formProperties.toBuilder()
                    .field(formProperties.getField().toBuilder()
                            .fields(List.of(passwordFieldProperty))
                            .build()
                    )
                    .build());
        }

    }

}
