package com.brizy.io.web.interactions.page.editor.container.components.type.form.type;

import com.brizy.io.web.common.dto.element.properties.form.FormProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.type.TelFieldProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.AbstractField;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.TelField;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.field.factory.FormField;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.toolbar.FormToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Tel implements FormField<TelFieldProperty> {

    Locator elementLocator;
    TelFieldToolbar toolbar;
    FormProperties formProperties;

    public Tel(ItemLocators itemLocators, FormProperties formProperties, Frame frame, Locator elementLocator) {
        this.formProperties = formProperties;
        this.elementLocator = elementLocator;
        var toolbarLocators = itemLocators.getToolbar();
        this.toolbar = new TelFieldToolbar(toolbarLocators, elementLocator, frame);
    }

    @Override
    public void setToolbarProperties(TelFieldProperty properties) {
        elementLocator.click();
        toolbar.setProperties(properties);
    }

    @Override
    public void configureFormField(TelFieldProperty properties) {
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

    protected class TelFieldToolbar extends FormToolbar<TelFieldProperty> {

        Supplier<TelField> telField;

        public TelFieldToolbar(ToolbarLocators toolbar, Locator elementLocator, Frame frame) {
            super(toolbar, frame);
            this.telField = () -> new TelField(toolbar.getField(), elementLocator, frame);
        }

        @Override
        public void setProperties(FormProperties properties) {
            super.setProperties(properties);
        }

        @Override
        public AbstractField<TelFieldProperty> getField() {
            return telField.get();
        }

        /**
         * This method was implemented to have a distinction between different fields, but, in the end,
         * the method from the superclass is called with some refactored DTO, because we have shared settings
         * of the form across all the field elements.
         *
         * @param telFieldProperty - properties for the tel field
         */
        @Override
        public void setProperties(TelFieldProperty telFieldProperty) {
            super.setProperties(formProperties.toBuilder()
                    .field(formProperties.getField().toBuilder()
                            .fields(List.of(telFieldProperty))
                            .build()
                    )
                    .build());
        }

    }

}
