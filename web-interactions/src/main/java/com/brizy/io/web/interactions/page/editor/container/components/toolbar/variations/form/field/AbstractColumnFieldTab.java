package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field;

import com.brizy.io.web.common.dto.element.properties.form.field.configuration.type.FieldWithOptionsAndColumnsConfigurationProperty;
import com.brizy.io.web.common.dto.element.properties.form.field.type.AbstractFieldProperty;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.FieldLocator;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AbstractColumnFieldTab extends AbstractRequiredFieldTab {

    Supplier<ComboBox> columns;

    public AbstractColumnFieldTab(FieldLocator field, Frame frame) {
        super(field, frame);
        this.columns = () -> new ComboBox(frame.locator(field.getColumns()));
    }

    @Override
    public void applyProperties(AbstractFieldProperty fieldsProperties) {
        super.applyProperties(fieldsProperties);
        var configuration = (FieldWithOptionsAndColumnsConfigurationProperty) fieldsProperties.getConfiguration();
        columns.get().selectItemByName(configuration.getColumns());
    }

}
