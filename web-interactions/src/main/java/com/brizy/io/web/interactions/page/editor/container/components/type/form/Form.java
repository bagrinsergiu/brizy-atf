package com.brizy.io.web.interactions.page.editor.container.components.type.form;

import com.brizy.io.web.common.dto.element.properties.form.FormProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.type.FieldsProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.Component;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.type.form.field.factory.FieldsFactory;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@Getter
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class Form extends Component<FormProperties> {

    Supplier<Frame> currentFrame;
    Supplier<ItemLocators> itemLocators;
    Supplier<List<Locator>> formFields;
    Supplier<Boolean> clearForm;

    public Form(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.currentFrame = () -> frame;
        this.formFields = () -> frame.locator(itemLocators.getType().getForm().getSelf())
                .locator(itemLocators.getType().getForm().getField().getSelf()).all();
        this.itemLocators = () -> itemLocators;
        this.clearForm = () -> clearFormFields(frame);
    }

    private Locator getLatestElement() {
        var locators = formFields.get();
        return locators.get(locators.size() - 1);
    }

    private Boolean clearFormFields(Frame frame) {
        var formFields = this.formFields.get();
        formFields.stream()
                .limit(formFields.size() - 1)
                .forEach(locator -> {
                    locator.click();
                    frame.locator("//*[@title='Delete']").click();
                });
        this.formFields.get().forEach(Locator::click);
        return true;
    }

    //    Intentionally left blank
    @Override
    protected ComponentToolbar<FormProperties> getToolbar() {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void configure(FormProperties properties) {
        var fields = properties.getField().getFields();
        for (FieldsProperties field : fields) {
            var createdField = FieldsFactory.getField(itemLocators.get(), properties, field, currentFrame.get(), getLatestElement());
            createdField.setToolbarProperties(field);
            createdField.configureFormField(field);
            if (!(fields.indexOf(field) == (fields.size() - 1))) {
                createdField.duplicate();
            }
            currentFrame.get().page().press("//*", "Escape");
        }
    }


    @Override
    public FormProperties getEditorProperties() {
//        TODO implement
        return null;
    }

}
