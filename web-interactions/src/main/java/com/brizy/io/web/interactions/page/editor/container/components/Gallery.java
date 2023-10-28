package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.gallery.GalleryProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.GalleryToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Gallery extends Component<GalleryProperties> {

    GalleryToolbar toolbar;

    @Override
    public ComponentToolbar<GalleryProperties> onToolbar() {
        toolbar.openToolbar();
        return toolbar;
    }

    public Gallery(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new GalleryToolbar(itemLocators.getToolbar(), frame);
    }

    @Override
    public GalleryProperties getEditorProperties() {
        return toolbar.getProperties();
    }

}
