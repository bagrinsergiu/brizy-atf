package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.image.ImageProperties;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.ImageToolbar;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Image extends Component<ImageProperties> {

    ImageToolbar toolbar;

    public Image(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new ImageToolbar(itemLocators.getToolbar(), frame);
    }

    @Override
    public ImageProperties getEditorProperties() {
        return toolbar.getProperties();
    }

}
