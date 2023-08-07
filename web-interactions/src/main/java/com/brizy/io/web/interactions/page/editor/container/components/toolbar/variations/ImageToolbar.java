package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations;

import com.brizy.io.web.common.dto.element.properties.image.ImageProperties;
import com.brizy.io.web.common.dto.element.properties.text.TextProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.typography.TextPropertyDto;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.Image;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.text.typography.Typography;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.ToolbarProperties;
import com.microsoft.playwright.Frame;

import java.util.Objects;
import java.util.function.Supplier;

public class ImageToolbar extends ComponentToolbar<ImageProperties> {

    Supplier<Button> imageButton;
    Supplier<Image> image;

    public ImageToolbar(ToolbarProperties properties, Frame frame) {
        super(properties, frame);
        this.imageButton = () -> new Button(frame.locator(properties.getImage().getSelf()));
        this.image = () -> new Image(properties.getImage(), frame);
    }

    protected void openImage() {
        imageButton.get().click();
    }

    @Override
    public void withProperties(ImageProperties properties) {
        if (Objects.nonNull(properties) && Objects.nonNull(properties.getImage())) {
            openImage();
            image.get().applyProperties(properties.getImage());
        }
    }

    @Override
    public EditorComponentProperty getProperties() {
        openImage();
        //TODO implement
        return null;
    }

}