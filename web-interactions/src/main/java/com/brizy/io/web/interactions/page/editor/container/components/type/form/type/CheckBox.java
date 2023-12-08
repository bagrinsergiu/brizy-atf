package com.brizy.io.web.interactions.page.editor.container.components.type.form.type;

import com.brizy.io.web.common.dto.element.properties.form.FormProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.type.CheckBoxFieldProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.check_box.item.CheckBoxItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.AbstractField;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type.CheckBoxField;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.field.factory.FormField;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.toolbar.FormToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.type.check_box.CheckBoxItem;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.type.check_box.CheckBoxNewItem;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CheckBox implements FormField<CheckBoxFieldProperty> {

    Locator elementLocator;
    CheckBoxFieldToolbar toolbar;
    FormProperties formProperties;
    Supplier<List<CheckBoxItem>> items;
    Supplier<CheckBoxNewItem> newItem;

    public CheckBox(ItemLocators itemLocators, FormProperties formProperties, Frame frame, Locator elementLocator) {
        var toolbarLocators = itemLocators.getToolbar();
        var fieldLocators = itemLocators.getToolbar().getField().getTabs().getField();
        this.formProperties = formProperties;
        this.elementLocator = elementLocator;
        this.toolbar = new CheckBoxFieldToolbar(toolbarLocators, elementLocator, frame);
        this.items = () -> initializeItems(fieldLocators.getCheckBox().getItem(), frame);
        this.newItem = () -> new CheckBoxNewItem(fieldLocators.getCheckBox().getNewItem(), frame);
    }

    private List<CheckBoxItem> initializeItems(CheckBoxItemLocators checkboxItemLocators, Frame frame) {
        return frame.locator(checkboxItemLocators.getSelf()).all().stream()
                .map(locator -> new CheckBoxItem(checkboxItemLocators, locator))
                .toList();
    }

    private void cleanCheckBoxes() {
        while (!items.get().isEmpty()) {
            items.get().get(0).deleteItem();
        }
    }

    @Override
    public void setToolbarProperties(CheckBoxFieldProperty properties) {
        elementLocator.click();
        toolbar.setProperties(properties);
    }

    @Override
    public void configureFormField(CheckBoxFieldProperty properties) {
        elementLocator.click();
        cleanCheckBoxes();
        var configuration = properties.getConfiguration();
        configuration.getOptions().forEach(string -> {
            var checkBoxNewItem = newItem.get();
            checkBoxNewItem.addNewOption(string);
            checkBoxNewItem.add();
        });
    }

    @Override
    public void duplicate() {
        toolbar.duplicate();
    }

    @Override
    public void delete() {
        toolbar.delete();
    }

    protected class CheckBoxFieldToolbar extends FormToolbar<CheckBoxFieldProperty> {

        Supplier<CheckBoxField> checkBoxField;

        public CheckBoxFieldToolbar(ToolbarLocators toolbar, Locator elementLocator, Frame frame) {
            super(toolbar, frame);
            this.checkBoxField = () -> new CheckBoxField(toolbar.getField(), elementLocator, frame);
        }

        @Override
        public void setProperties(FormProperties properties) {
            super.setProperties(properties);
        }

        @Override
        public AbstractField<CheckBoxFieldProperty> getField() {
            return checkBoxField.get();
        }

        /**
         * This method was implemented to have a distinction between different fields, but, in the end,
         * the method from the superclass is called with some refactored DTO, because we have shared settings
         * of the form across all the field elements.
         *
         * @param checkBoxFieldProperty - properties for the checkBox field
         */
        @Override
        public void setProperties(CheckBoxFieldProperty checkBoxFieldProperty) {
            super.setProperties(formProperties.toBuilder()
                    .field(formProperties.getField().toBuilder()
                            .fields(List.of(checkBoxFieldProperty))
                            .build()
                    )
                    .build());
        }

    }

}
