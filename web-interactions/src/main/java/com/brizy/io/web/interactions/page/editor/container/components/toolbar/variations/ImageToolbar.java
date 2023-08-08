package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.image.ImageProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.Image;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.colors.Colors;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.ToolbarProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ImageToolbar extends ComponentToolbar<ImageProperties> {

    Supplier<Button> imageButton;
    Supplier<Image> image;
    Supplier<Colors> colors;

    public ImageToolbar(ToolbarProperties properties, Frame frame) {
        super(properties, frame);
        this.imageButton = () -> new Button(frame.locator(properties.getImage().getSelf()));
        this.image = () -> new Image(properties.getImage(), frame);
        this.colors = () -> new Colors(properties.getColors(), frame);
    }

    protected void openImage() {
        imageButton.get().click();
    }

    @Override
    public void withProperties(ImageProperties properties) {
        if (Objects.nonNull(properties)) {
            if (Objects.nonNull(properties.getImage())) {
                openImage();
                image.get().applyProperties(properties.getImage());
            }
            if (Objects.nonNull(properties.getColors())) {
                openColors();
                colors.get().applyProperties(properties.getColors());
            }
        }
    }

    @Override
    public EditorComponentProperty getProperties() {
        openImage();
        //TODO implement
        return null;
    }

}