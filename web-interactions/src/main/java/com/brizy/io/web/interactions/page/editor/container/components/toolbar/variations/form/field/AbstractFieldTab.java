package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field;

import com.brizy.io.web.common.dto.element.properties.common.InputWithUnitsProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.type.AbstractFieldProperty;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.FieldLocator;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AbstractFieldTab {

    ComboBox type;
    InputWithUnits spacing;

    public AbstractFieldTab(FieldLocator field, Frame frame) {
        this.type = new ComboBox(frame.locator(field.getType()));
        this.spacing = new InputWithUnits(field.getSpacing(), frame);
    }

    public void applyProperties(AbstractFieldProperty fieldsProperties) {
        if (Objects.nonNull(fieldsProperties.getType())) {
            type.selectItemByValue(fieldsProperties.getType());
        }
        if (Objects.nonNull(fieldsProperties.getSpacing())) {
            spacing.setValue(InputWithUnitsProperties.builder()
                    .value(fieldsProperties.getSpacing())
                    .build());
        }
    }

}
