package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.gallery.pop_up.tabs;

import com.brizy.io.web.common.dto.element.properties.gallery.pop_up.GalleryPopUpProperties;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.gallery.GalleryLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.gallery.pop_up.tabs.gallery.GalleryTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.gallery.pop_up.tabs.items.ItemsTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.$;
import static io.vavr.API.Case;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GalleryPopUp extends AbstractToolbarItem {

    Supplier<GalleryTab> gallery;
    Supplier<ItemsTab> items;

    public GalleryPopUp(GalleryLocators galleryLocators, Frame frame) {
        super(galleryLocators.getSelf(), galleryLocators.getTabs().getSelf(), frame);
        var galleryLocatorsTabs = galleryLocators.getTabs();
        this.gallery = () -> new GalleryTab(galleryLocatorsTabs.getGallery(), frame);
        this.items = () -> new ItemsTab(galleryLocatorsTabs.getItems(), frame);
    }

    public void applyProperties(GalleryPopUpProperties galleryPopUpProperties) {
        open();
        if (Objects.nonNull(galleryPopUpProperties.getGallery())) {
            gallery.get().applyProperties(galleryPopUpProperties.getGallery());
        }
        if (Objects.nonNull(galleryPopUpProperties.getItems())) {
            items.get().applyProperties(galleryPopUpProperties.getItems());
        }
    }

    public GalleryPopUpProperties getProperties() {
        open();
        return GalleryPopUpProperties.builder()
                .gallery(gallery.get().getProperties())
                .items(items.get().getProperties())
                .build();
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return io.vavr.API.Match(tab.toLowerCase()).of(
                Case($(Fields.gallery), gallery),
                Case($(Fields.items), items)
        );
    }
}
