package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.size;

import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.Size;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.tabs.mask.MaskProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.Objects;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public abstract class AbstractSize {

    Supplier<ComboBox> position;

    public AbstractSize(MaskProperties mask, Frame frame) {
        this.position = () -> new ComboBox(frame.locator(mask.getPosition()));
    }

    public void selectPosition(String position) {
        if (Objects.nonNull(position) && !position.isEmpty()) {
            this.position.get().selectItemByName(position);
        }
    }

    public abstract void applyProperties(Size size);
}
