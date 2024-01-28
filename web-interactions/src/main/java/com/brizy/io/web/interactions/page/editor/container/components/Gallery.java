package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.gallery.GalleryProperties;
import com.brizy.io.web.common.dto.element.type.Content;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.content.variations.gallery.GalleryContent;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.GalleryToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public class Gallery extends ComponentWithContent<GalleryProperties> {

    GalleryToolbar toolbar;
    Supplier<Button> borderButton;
    Supplier<GalleryContent> galleryContent;

    public Gallery(ItemLocators itemLocators, Frame frame, Locator locator) {
        super(frame, locator, itemLocators);
        this.toolbar = new GalleryToolbar(itemLocators.getToolbar(), frame);
        this.borderButton = () -> new Button(frame.locator(itemLocators.getBorderButton()));
        this.galleryContent = () -> new GalleryContent(itemLocators, frame, locator);
    }

    @Override
    public GalleryProperties getEditorProperties() {
        return toolbar.getProperties();
    }

    @Override
    protected void openToolbar() {
        borderButton.get().click();
    }

    @Override
    public <Type extends Content> void configureContents(List<Type> content) {
//        galleryContent.get().setContent(content);
    }

}
