package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.ButtonToolbar;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.ItemProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Button extends Component {

    @Getter
    ButtonToolbar toolbar;

    public Button(ItemProperties itemProperties, Frame frame, Locator locator) {
        super(frame, locator, itemProperties);
        this.toolbar = new ButtonToolbar(itemProperties.getToolbar(), frame);
    }

    @Override
    protected EditorComponentProperty getEditorProperties() {
        return toolbar.getProperties();
    }
}
