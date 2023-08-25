package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.mask.shape;

import com.brizy.io.web.common.dto.element.properties.image.image.mask.shape.CustomMask;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.FileUploader;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.tabs.mask.MaskProperties;
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
public class CustomShape {

    Supplier<FileUploader> image;

    public CustomShape(MaskProperties mask, Frame frame) {
        this.image = () -> new FileUploader(mask.getImage(), frame);
    }

    public void applyProperties(CustomMask customMask) {
        if (Objects.nonNull(customMask.getImage()) && !customMask.getImage().isEmpty()) {
            image.get().uploadFile(Paths.get(customMask.getImage()));
        }
    }

    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(Fields.image).element(image).build()
        );
    }
}
