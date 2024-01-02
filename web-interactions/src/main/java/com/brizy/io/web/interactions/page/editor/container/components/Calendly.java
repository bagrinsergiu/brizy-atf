package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.calendly.CalendlyProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.CalendlyToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Calendly extends Component<CalendlyProperties> {

    CalendlyToolbar toolbar;

    public Calendly(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new CalendlyToolbar(itemLocators.getToolbar(), frame);
    }

    @Override
    public CalendlyProperties getEditorProperties() {
        return toolbar.getProperties();
    }

}
