package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image;

import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.ImageLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractToolbarItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.IsPopUpTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.image.ImageTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.mask.MaskTab;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

import static com.brizy.io.web.common.dto.element.properties.image.image.Image.builder;
import static io.vavr.API.*;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Image extends AbstractToolbarItem {

    Supplier<ImageTab> image;
    Supplier<MaskTab> mask;

    public Image(ImageLocators imageLocators, Frame frame) {
        super(imageLocators.getSelf(), imageLocators.getTabs().getSelf(), frame);
        this.image = () -> new ImageTab(imageLocators.getTabs().getImage(), frame);
        this.mask = () -> new MaskTab(imageLocators.getTabs().getMask(), frame);
    }

    public void applyProperties(com.brizy.io.web.common.dto.element.properties.image.image.Image image) {
        open();
        if (Objects.nonNull(image.getImage())) {
            this.image.get().applyProperties(image.getImage());
        }
        if (Objects.nonNull(image.getMask())) {
            this.mask.get().applyProperties(image.getMask());
        }
    }

    @Override
    public IsPopUpTab openTab(String tab) {
        open();
        return Match(tab.toLowerCase()).of(
                Case($(Fields.image), image),
                Case($(), mask)
        );
    }

    public com.brizy.io.web.common.dto.element.properties.image.image.Image getProperties() {
        open();
        return builder()
                .image(image.get().getProperties())
                .mask(mask.get().getProperties())
                .build();
    }

//    TODO implement
//    public ImageDto getProperties() {
//
//    }

}
