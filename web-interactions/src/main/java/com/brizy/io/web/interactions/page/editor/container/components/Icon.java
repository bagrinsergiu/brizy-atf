package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.icon.IconProperties;
import com.brizy.io.web.common.dto.element.properties.image.ImageProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemProperties;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.IconToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.ImageToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Icon extends Component<IconProperties> {

    IconToolbar toolbar;

    public Icon(ItemProperties itemProperties, Frame frame, Locator locator) {
        super(frame, locator, itemProperties);
        this.toolbar = new IconToolbar(itemProperties.getToolbar(), frame);
    }

    @Override
    public IconProperties getEditorProperties() {
        return toolbar.getProperties();
    }

}
