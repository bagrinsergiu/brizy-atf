package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.gallery.pop_up.tabs.gallery;

import com.brizy.io.web.common.dto.element.properties.gallery.pop_up.tabs.gallery.GalleryTabProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.gallery.tabs.gallery.GalleryTabLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import io.vavr.control.Try;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class GalleryTab extends AbstractTabItem {

    Supplier<FileUploader> images;
    Supplier<ComboBox> layout;
    Supplier<InputWithUnits> height;
    Supplier<ComboBox> aspectRatio;
    Supplier<Slider> enableTags;
    Supplier<Slider> openInLightBox;

    public GalleryTab(GalleryTabLocators galleryTabLocators, Frame frame) {
        super(galleryTabLocators.getConfigurations(), galleryTabLocators.getSelf(), frame);
        this.images = () -> new FileUploader(galleryTabLocators.getImages(), frame);
        this.layout = () -> new ComboBox(frame.locator(galleryTabLocators.getLayout()));
        this.height = () -> new InputWithUnits(galleryTabLocators.getHeight(), frame);
        this.aspectRatio = () -> new ComboBox(frame.locator(galleryTabLocators.getAspectRatio()));
        this.enableTags = () -> new Slider(frame.locator(galleryTabLocators.getEnableTags()));
        this.openInLightBox = () -> new Slider(frame.locator(galleryTabLocators.getOpenInLightBox()));
    }

    public void applyProperties(GalleryTabProperties galleryTabProperties) {
        open();
        if (Objects.nonNull(galleryTabProperties.getImages())) {
//            images.get().uploadFiles(galleryTabProperties.getImages());
        }
        if (Objects.nonNull(galleryTabProperties.getLayout())) {
            layout.get().selectItemByName(galleryTabProperties.getLayout());
        }
        if (Objects.nonNull(galleryTabProperties.getHeight())) {
            height.get().setValue(galleryTabProperties.getHeight());
        }
        if (Objects.nonNull(galleryTabProperties.getAspectRatio())) {
            aspectRatio.get().selectItemByName(galleryTabProperties.getAspectRatio());
        }
        if (Objects.nonNull(galleryTabProperties.getEnableTags())) {
            enableTags.get().switchTo(galleryTabProperties.getEnableTags());
        }
        if (Objects.nonNull(galleryTabProperties.getOpenInLightBox())) {
            openInLightBox.get().switchTo(galleryTabProperties.getOpenInLightBox());
        }
    }

    public GalleryTabProperties getProperties() {
        open();
        return GalleryTabProperties.builder()
//                .images(images.get().getFileName())
                .layout(layout.get().getSelectedItem())
                .height(Try.of(() -> height.get().getValue()).getOrElse(() -> null))
                .aspectRatio(aspectRatio.get().getSelectedItem())
                .enableTags(enableTags.get().getState())
                .openInLightBox(openInLightBox.get().getState())
                .build();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.images).element(images).build(),
                Configuration.builder().name(Fields.layout).element(layout).build(),
                Configuration.builder().name(Fields.height).element(height).build(),
                Configuration.builder().name("aspect ratio").element(aspectRatio).build(),
                Configuration.builder().name("enable tags").element(enableTags).build(),
                Configuration.builder().name("open in lightbox").element(openInLightBox).build()
        );
    }

}
