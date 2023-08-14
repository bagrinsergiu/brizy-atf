package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.size;

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
public abstract class AbstractFitSize extends AbstractSize {

    Supplier<ComboBox> repeat;

    public AbstractFitSize(MaskProperties mask, Frame frame) {
        super(mask, frame);
        this.repeat = () -> new ComboBox(frame.locator(mask.getRepeat()));
    }

    public void selectRepeat(String repeat) {
        if (Objects.nonNull(repeat) && !repeat.isEmpty()) {
            this.repeat.get().selectItemByName(repeat);
        }
    }

}
