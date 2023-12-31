package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.image;

import com.brizy.io.web.common.dto.element.properties.image.image.image.Image;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.element.RangeInput;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.tabs.image.ImageLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ImageTab extends AbstractTabItem {

    Supplier<FileUploader> image;
    Supplier<RangeInput> zoom;
    Supplier<Slider> openInLightBox;

    public ImageTab(ImageLocators image, Frame frame) {
        super(image.getConfigurations(), image.getSelf(), frame);
        this.image = () -> new FileUploader(image.getImage(), frame);
        this.zoom = () -> new RangeInput(frame.locator(image.getZoom()));
        this.openInLightBox = () -> new Slider(frame.locator(image.getOpenInLightBox()));
    }

    public void applyProperties(Image image) {
        open();
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
    public List<Configuration> getConfigurations() {
        open();
        return List.of(
                Configuration.builder().name(Fields.image).element(image).build(),
                Configuration.builder().name(Fields.zoom).element(zoom).build(),
                Configuration.builder().name(Fields.openInLightBox).element(openInLightBox).build()
        );
    }

    public Image getProperties() {
        open();
        return Image.builder()
//                .image(image.get().getFileName())
                .zoom(zoom.get().getValue())
                .openInLightBox(openInLightBox.get().getState())
                .build();
    }
}
