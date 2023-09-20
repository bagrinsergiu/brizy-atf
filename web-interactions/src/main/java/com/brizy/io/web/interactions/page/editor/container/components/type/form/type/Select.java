package com.brizy.io.web.interactions.page.editor.container.components.type.form.type;

import com.brizy.io.web.common.dto.element.properties.form.FormProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.type.SelectFieldProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.select.item.SelectItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.FormToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.AbstractField;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.SelectField;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.field.factory.FormField;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.type.select.SelectItem;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.type.select.SelectNewItem;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Select implements FormField<SelectFieldProperty> {

    Locator elementLocator;
    SelectFieldToolbar toolbar;
    FormProperties formProperties;
    Supplier<List<SelectItem>> items;
    Supplier<SelectNewItem> newItem;

    public Select(ItemLocators itemLocators, FormProperties formProperties, Frame frame, Locator elementLocator) {
        var toolbarLocators = itemLocators.getToolbar();
        var fieldLocators = itemLocators.getToolbar().getField().getTabs().getField();
        this.formProperties = formProperties;
        this.elementLocator = elementLocator;
        this.toolbar = new SelectFieldToolbar(toolbarLocators, elementLocator, frame);
        this.items = () -> initializeItems(fieldLocators.getSelect().getItem(), frame);
        this.newItem = () -> new SelectNewItem(fieldLocators.getSelect().getNewItem(), frame);
    }

    private List<SelectItem> initializeItems(SelectItemLocators selectItemLocators, Frame frame) {
        return frame.locator(selectItemLocators.getSelf()).all().stream()
                .map(locator -> new SelectItem(selectItemLocators, locator))
                .toList();
    }

    private void cleanSelects() {
        while (!items.get().isEmpty()) {
            items.get().get(0).deleteItem();
        }
    }

    @Override
    public void setToolbarProperties(SelectFieldProperty properties) {
        elementLocator.click();
        toolbar.setProperties(properties);
    }

    @Override
    public void configureFormField(SelectFieldProperty properties) {
        var placeholder = properties.getPlaceholder();
        elementLocator.locator("//input").fill(placeholder);
        elementLocator.click();
        cleanSelects();
        var configuration = properties.getConfiguration();
        configuration.getOptions().forEach(string -> {
            var selectNewItem = newItem.get();
            selectNewItem.addNewOption(string);
            selectNewItem.add();
        });
        elementLocator.click();
    }

    @Override
    public void duplicate() {
        toolbar.duplicate();
    }

    @Override
    public void delete() {
        toolbar.delete();
    }

    protected class SelectFieldToolbar extends FormToolbar<SelectFieldProperty> {

        Supplier<SelectField> selectField;

        public SelectFieldToolbar(ToolbarLocators toolbar, Locator elementLocator, Frame frame) {
            super(toolbar, frame);
            this.selectField = () -> new SelectField(toolbar.getField(), elementLocator, frame);
        }

        @Override
        public void setProperties(FormProperties properties) {
            super.setProperties(properties);
        }

        @Override
        public AbstractField<SelectFieldProperty> getField() {
            return selectField.get();
        }

        /**
         * This method was implemented to have a distinction between different fields, but, in the end,
         * the method from the superclass is called with some refactored DTO, because we have shared settings
         * of the form across all the field elements.
         *
         * @param selectFieldProperty - properties for the select field
         */
        @Override
        public void setProperties(SelectFieldProperty selectFieldProperty) {
            super.setProperties(formProperties.toBuilder()
                    .field(formProperties.getField().toBuilder()
                            .fields(List.of(selectFieldProperty))
                            .build()
                    )
                    .build());
        }

    }

}
