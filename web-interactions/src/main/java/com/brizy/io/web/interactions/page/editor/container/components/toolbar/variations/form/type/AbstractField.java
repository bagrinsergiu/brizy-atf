package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.type;

import com.brizy.io.web.common.dto.element.properties.form.field.FieldProperties;
import com.brizy.io.web.common.dto.element.properties.form.field.type.FieldsProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.FieldLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.advanced.AdvancedTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.background.BackgroundTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@SuppressWarnings("all")
public abstract class AbstractField<T extends FieldsProperties> {

    Supplier<AdvancedTab> advanced;
    Supplier<BackgroundTab> background;

    public AbstractField(FieldLocators field, Frame frame) {
        this.advanced = () -> new AdvancedTab(field.getTabs().getAdvanced(), frame);
        this.background = () -> new BackgroundTab(field.getTabs().getBackground(), frame);
    }

    public void applyProperties(FieldProperties field) {
        if (Objects.nonNull(field.getFields()) && !field.getFields().isEmpty()) {
            applyFieldProperties((T) field.getFields().get(0));
        }
        if (Objects.nonNull(field.getAdvanced())) {
            advanced.get().applyProperties(field.getAdvanced());
        }
        if (Objects.nonNull(field.getBackground())) {
            background.get().applyProperties(field.getBackground());
        }
    }

    public abstract void applyFieldProperties(T fieldsProperties);

}
