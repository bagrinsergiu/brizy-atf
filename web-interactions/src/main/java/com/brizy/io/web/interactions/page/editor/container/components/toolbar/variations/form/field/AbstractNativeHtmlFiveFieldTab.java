package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.form.field;

import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.field.field.FieldLocator;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AbstractNativeHtmlFiveFieldTab extends AbstractRequiredFieldTab {

    Slider nativeHtml5;

    public AbstractNativeHtmlFiveFieldTab(FieldLocator field, Frame frame) {
        super(field, frame);
        this.nativeHtml5 = new Slider(frame.locator(field.getNativeHtml5()));
    }

}
