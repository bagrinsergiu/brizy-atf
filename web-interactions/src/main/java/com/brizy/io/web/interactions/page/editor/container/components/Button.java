package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.button.ButtonProperties;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.ButtonToolbar;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Button extends Component<ButtonProperties> {

    @Getter
    ButtonToolbar toolbar;

    public Button(ItemProperties itemProperties, Frame frame, Locator locator) {
        super(frame, locator, itemProperties);
        this.toolbar = new ButtonToolbar(itemProperties.getToolbar(), frame);
    }

    @Override
    protected ButtonProperties getEditorProperties() {
        return toolbar.getProperties();
    }
}
