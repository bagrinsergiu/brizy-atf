package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.TextToolbar;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.ItemProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Text extends Component {

    @Getter
    TextToolbar toolbar;

    public Text(ItemProperties itemProperties, Frame frame, Locator locator) {
        super(frame, locator, itemProperties);
        this.toolbar = new TextToolbar(itemProperties.getToolbar(), frame);
    }

    @Override
    public EditorComponentProperty getEditorProperties() {
        return toolbar.getProperties();
    }
}
