package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.FieldLocator;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RadioFieldTab extends AbstractColumnFieldTab {

    public RadioFieldTab(FieldLocator fieldLocators, Frame frame) {
        super(fieldLocators, frame);
    }

}
