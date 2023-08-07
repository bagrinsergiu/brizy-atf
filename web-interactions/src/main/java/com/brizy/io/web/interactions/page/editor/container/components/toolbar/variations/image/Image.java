package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image;

import com.brizy.io.web.interactions.page.editor.container.components.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.ImageTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.MaskTab;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.ImageProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Image {

    Supplier<ImageTab> image;
    Supplier<MaskTab> mask;

    public Image(ImageProperties properties, Frame frame) {
        this.image = () -> new ImageTab(properties.getTabs().getImage(), frame);
        this.mask = () -> new MaskTab(properties.getTabs().getMask(), frame);
    }

    public void applyProperties(com.brizy.io.web.common.dto.element.properties.toolbar.image.Image image) {
        if (Objects.nonNull(image.getImage())) {
            this.image.get().applyProperties(image.getImage());
        }
        if (Objects.nonNull(image.getMask())) {
            this.mask.get().applyProperties(image.getMask());
        }
    }

//    TODO implement
//    public ImageDto getProperties() {
//
//    }

}
