package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.button.ButtonProperties;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.ButtonToolbar;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Button extends Component<ButtonProperties> {

    @Getter
    ButtonToolbar toolbar;

    public Button(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new ButtonToolbar(itemLocators.getToolbar(), frame);
    }

    @Override
    protected ButtonProperties getEditorProperties() {
        return toolbar.getProperties();
    }
}
