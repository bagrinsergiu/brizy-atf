package com.brizy.io.web.interactions.page.editor.container.components.type.form.type;

import com.brizy.io.web.common.dto.element.properties.form.FormProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.type.HiddenFieldProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.AbstractField;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.HiddenField;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.field.factory.FormField;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.toolbar.FormToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Hidden implements FormField<HiddenFieldProperty> {

    HiddenFieldToolbar toolbar;
    FormProperties formProperties;

    public Hidden(ItemLocators itemLocators, FormProperties formProperties, Frame frame, Locator elementLocator) {
        this.formProperties = formProperties;
        var toolbarLocators = itemLocators.getToolbar();
        this.toolbar = new HiddenFieldToolbar(toolbarLocators, elementLocator, frame);
    }

    @Override
    public void setToolbarProperties(HiddenFieldProperty properties) {
        toolbar.setProperties(properties);
    }

    @Override
    public void duplicate() {
        toolbar.duplicate();
    }

    @Override
    public void delete() {
        toolbar.delete();
    }

    protected class HiddenFieldToolbar extends FormToolbar<HiddenFieldProperty> {

        Supplier<HiddenField> hiddenField;

        public HiddenFieldToolbar(ToolbarLocators toolbar, Locator elementLocator, Frame frame) {
            super(toolbar, frame);
            this.hiddenField = () -> new HiddenField(toolbar.getField(), elementLocator, frame);
        }

        @Override
        public void setProperties(FormProperties properties) {
            super.setProperties(properties);
        }

        @Override
        public AbstractField<HiddenFieldProperty> getField() {
            return hiddenField.get();
        }

        /**
         * This method was implemented to have a distinction between different fields, but, in the end,
         * the method from the superclass is called with some refactored DTO, because we have shared settings
         * of the form across all the field elements.
         *
         * @param hiddenFieldProperty - properties for the hidden field
         */
        @Override
        public void setProperties(HiddenFieldProperty hiddenFieldProperty) {
            super.setProperties(formProperties.toBuilder()
                    .field(formProperties.getField().toBuilder()
                            .fields(List.of(hiddenFieldProperty))
                            .build()
                    )
                    .build());
        }

    }

}
