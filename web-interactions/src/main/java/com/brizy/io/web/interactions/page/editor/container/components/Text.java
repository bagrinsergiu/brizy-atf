package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.text.TextProperties;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.TextToolbar;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Text extends Component<TextProperties> {

    @Getter
    TextToolbar toolbar;

    public Text(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new TextToolbar(itemLocators.getToolbar(), frame);
    }

    @Override
    public TextProperties getEditorProperties() {
        return toolbar.getProperties();
    }
}
