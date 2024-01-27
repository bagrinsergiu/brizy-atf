package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.gallery.GalleryProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.ToolbarLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.Toolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.gallery.pop_up.tabs.GalleryPopUp;
import com.microsoft.playwright.Frame;
import io.vavr.API;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.$;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class GalleryToolbar extends Toolbar<GalleryProperties> {

    Supplier<GalleryPopUp> gallery;

    public GalleryToolbar(ToolbarLocators toolbarLocators, Frame frame) {
        super(toolbarLocators, frame);
        this.gallery = () -> new GalleryPopUp(toolbarLocators.getGallery(), frame);
    }

    @Override
    public GalleryProperties getProperties() {
        return GalleryProperties.builder()
                .gallery(gallery.get().getProperties())
                .build();
    }

    @Override
    public void setProperties(GalleryProperties properties) {
        if (Objects.nonNull(properties.getGallery())) {
            gallery.get().applyProperties(properties.getGallery());
        }
    }

    @Override
    public IsToolbarItem openTabbedPopup(String toolbarItemTitle) {
        return API.Match(toolbarItemTitle.toLowerCase()).of(
                API.Case($(Fields.gallery), gallery)
        );
    }

}