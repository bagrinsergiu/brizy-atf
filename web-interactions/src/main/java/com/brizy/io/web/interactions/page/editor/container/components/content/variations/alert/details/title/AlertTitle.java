package com.brizy.io.web.interactions.page.editor.container.components.content.variations.alert.details.title;

import com.brizy.io.web.common.dto.element.content.alert.details.properties.AlertContentProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.content.variations.alert.details.CommonAlertDetails;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AlertTitle extends CommonAlertDetails<AlertContentProperties> {

    public AlertTitle(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(itemLocators, frame, locator);
    }

}
