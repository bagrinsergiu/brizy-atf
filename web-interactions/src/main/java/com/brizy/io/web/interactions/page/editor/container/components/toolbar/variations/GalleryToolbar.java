package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.gallery.GalleryProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import static io.vavr.API.$;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class GalleryToolbar extends ComponentToolbar<GalleryProperties> {

    public GalleryToolbar(ToolbarLocators toolbarLocators, Frame page) {
        super(toolbarLocators, page);
       /* var galleryLocators = toolbarLocators.getIcon();

        this.colors = () -> new Colors(toolbarLocators.getColors(), page);
        this.link = () -> new Link(toolbarLocators.getLink(), page);*/
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return null;
    }

    @Override
    public GalleryProperties getProperties() {
        return null;
    }
    public void openToolbar(){
        openBorderButton();
    }


    @Override
    public void setProperties(GalleryProperties properties) {
        openBorderButton();
        System.out.println();
    }

}