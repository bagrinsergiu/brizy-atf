package com.brizy.io.web.interactions.page.editor.container.components.content.variations.alert.details;

import com.brizy.io.web.common.dto.element.content.alert.details.AlertCommon;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.Text;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;

import java.util.function.Supplier;

public abstract class CommonAlertDetails<T extends com.brizy.io.web.common.dto.element.content.alert.details.properties.AlertContentProperties> extends Text {

    Supplier<TextInput> content;

    public CommonAlertDetails(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(itemLocators, frame, locator);
        content = () -> new TextInput(locator);
    }

    public void configureAlertDetails(AlertCommon<T> properties) {
        content.get().fill(properties.getValue());
        super.configure(properties.getProperties());
    }

}
