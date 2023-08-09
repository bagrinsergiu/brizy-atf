package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image;

import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTabbedPopup;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.ImageTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.MaskTab;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.ImageProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static io.vavr.API.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Image implements IsTabbedPopup {

    Supplier<ImageTab> image;
    Supplier<MaskTab> mask;
    Supplier<Locator> tabs;

    public Image(ImageProperties properties, Frame frame) {
        this.tabs = () -> frame.locator(properties.getTabs().getSelf());
        this.image = () -> new ImageTab(properties.getTabs().getImage(), frame);
        this.mask = () -> new MaskTab(properties.getTabs().getMask(), frame);
    }

    public void applyProperties(com.brizy.io.web.common.dto.element.properties.image.image.Image image) {
        if (Objects.nonNull(image.getImage())) {
            this.image.get().applyProperties(image.getImage());
        }
        if (Objects.nonNull(image.getMask())) {
            this.mask.get().applyProperties(image.getMask());
        }
    }

    @Override
    public IsTab openTab(String tab) {
        return Match(tab.toLowerCase()).of(
                Case($("image"), image.get()),
                Case($("mask"), () -> {
                    mask.get().open();
                    return mask.get();
                })
        );
    }

    @Override
    public List<String> getTabs() {
        return tabs.get().all().stream()
                .map(Locator::textContent)
                .toList();
    }

//    TODO implement
//    public ImageDto getProperties() {
//
//    }

}
