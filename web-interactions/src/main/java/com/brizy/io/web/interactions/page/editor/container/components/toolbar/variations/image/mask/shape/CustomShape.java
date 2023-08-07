package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.shape;

import com.brizy.io.web.common.dto.element.properties.toolbar.image.mask.shape.CustomMask;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.MaskTab;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.tabs.mask.MaskProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.nio.file.Paths;
import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CustomShape {

    Supplier<FileUploader> image;

    public CustomShape(MaskProperties mask, Frame frame) {
        this.image = () -> new FileUploader(frame.locator(mask.getImage()));
    }

    public void applyProperties(CustomMask customMask) {
        if (Objects.nonNull(customMask.getImage()) && !customMask.getImage().isEmpty()) {
            image.get().uploadFile(Paths.get(customMask.getImage()));
        }
    }

}
