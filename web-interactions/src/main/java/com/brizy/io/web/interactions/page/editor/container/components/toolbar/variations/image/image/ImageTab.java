package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image;

import com.brizy.io.web.common.dto.element.properties.image.image.image.Image;
import com.brizy.io.web.interactions.element.*;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTab;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.tabs.image.ImageProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ImageTab implements IsTab {

    Supplier<Button> imageTabButton;
    Supplier<FileUploader> image;
    Supplier<RangeInput> zoom;
    Supplier<Slider> openInLightBox;
    Supplier<Locator> configurations;

    public ImageTab(ImageProperties image, Frame frame) {
        this.configurations = () -> frame.locator(image.getConfigurations());
        this.imageTabButton = () -> new Button(frame.locator(image.getSelf()));
        this.image = () -> new FileUploader(frame.locator(image.getImage()));
        this.zoom = () -> new RangeInput(frame.locator(image.getZoom()));
        this.openInLightBox = () -> new Slider(frame.locator(image.getOpenInLightBox()));
    }

    public void applyProperties(Image image) {
        imageTabButton.get().click();
        if (Objects.nonNull(image.getImage()) && !image.getImage().isEmpty()) {
            this.image.get().uploadFile(Paths.get(image.getImage()));
        }
        if (Objects.nonNull(image.getZoom()) && image.getZoom() > 0) {
            zoom.get().fill(image.getZoom());
        }
        if (Objects.nonNull(image.getOpenInLightBox())) {
            openInLightBox.get().switchTo(image.getOpenInLightBox());
        }
    }

    @Override
    public List<String> getConfigurations() {
        return configurations.get().all().stream()
                .map(Locator::textContent)
                .toList();
    }

}
