package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.counter.CounterProperties;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.CounterToolbar;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Counter extends Component<CounterProperties> {

    @Getter
    CounterToolbar toolbar;

    public Counter(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new CounterToolbar(itemLocators.getToolbar(), frame);
    }

    @Override
    public CounterProperties getEditorProperties() {
        return toolbar.getProperties();
    }


}
