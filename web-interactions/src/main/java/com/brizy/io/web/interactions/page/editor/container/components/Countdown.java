package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.countdown.CountdownProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.CountdownToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Countdown extends Component<CountdownProperties> {

    CountdownToolbar toolbar;

    public Countdown(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new CountdownToolbar(itemLocators.getToolbar(), frame);
    }

    @Override
    public CountdownProperties getEditorProperties() {
        return toolbar.getProperties();
    }

}
