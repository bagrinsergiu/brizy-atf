package com.brizy.io.web.interactions.page.editor.container.components.type.form.type;

import com.brizy.io.web.common.dto.element.properties.form.FormProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.type.RadioFieldProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.radio.item.RadioItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.AbstractField;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.RadioField;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.field.factory.FormField;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.toolbar.FormToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.type.radio.RadioItem;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.type.radio.RadioNewItem;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Radio implements FormField<RadioFieldProperty> {

    Locator elementLocator;
    RadioFieldToolbar toolbar;
    FormProperties formProperties;
    Supplier<List<RadioItem>> items;
    Supplier<RadioNewItem> newItem;

    public Radio(ItemLocators itemLocators, FormProperties formProperties, Frame frame, Locator elementLocator) {
        var fieldLocators = itemLocators.getToolbar().getField().getTabs().getField();
        this.formProperties = formProperties;
        this.elementLocator = elementLocator;
        var toolbarLocators = itemLocators.getToolbar();
        this.toolbar = new RadioFieldToolbar(toolbarLocators, elementLocator, frame);
        this.items = () -> initializeItems(fieldLocators.getRadio().getItem(), frame);
        this.newItem = () -> new RadioNewItem(fieldLocators.getRadio().getNewItem(), frame);
    }

    private List<RadioItem> initializeItems(RadioItemLocators item, Frame frame) {
        return frame.locator(item.getSelf()).all().stream()
                .map(locator -> new RadioItem(item, locator))
                .toList();
    }

    private void cleanRadio() {
        while (!items.get().isEmpty()) {
            items.get().get(0).deleteItem();
        }
    }

    @Override
    public void configureFormField(RadioFieldProperty properties) {
        elementLocator.click();
        cleanRadio();
        var configuration = properties.getConfiguration();
        configuration.getOptions().forEach(string -> {
            var radioNewItem = newItem.get();
            radioNewItem.addNewOption(string);
            radioNewItem.add();
        });
    }

    @Override
    public void setToolbarProperties(RadioFieldProperty properties) {
        elementLocator.click();
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

    protected class RadioFieldToolbar extends FormToolbar<RadioFieldProperty> {

        Supplier<RadioField> radioField;

        public RadioFieldToolbar(ToolbarLocators toolbar, Locator elementLocator, Frame frame) {
            super(toolbar, frame);
            this.radioField = () -> new RadioField(toolbar.getField(), elementLocator, frame);
        }

        @Override
        public void setProperties(FormProperties properties) {
            super.setProperties(properties);
        }

        @Override
        public AbstractField<RadioFieldProperty> getField() {
            return radioField.get();
        }

        /**
         * This method was implemented to have a distinction between different fields, but, in the end,
         * the method from the superclass is called with some refactored DTO, because we have shared settings
         * of the form across all the field elements.
         *
         * @param radioFieldProperty - properties for the radio field
         */
        @Override
        public void setProperties(RadioFieldProperty radioFieldProperty) {
            super.setProperties(formProperties.toBuilder()
                    .field(formProperties.getField().toBuilder()
                            .fields(List.of(radioFieldProperty))
                            .build()
                    )
                    .build());
        }

    }

}
