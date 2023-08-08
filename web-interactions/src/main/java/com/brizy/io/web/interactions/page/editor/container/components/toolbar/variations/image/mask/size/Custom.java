package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.size;

import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.CustomSize;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.Size;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.tabs.mask.MaskProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Custom extends AbstractFitSize {

    Supplier<SizeInput> size;

    public Custom(MaskProperties mask, Frame frame) {
        super(mask, frame);
        this.size = () -> new SizeInput(mask.getSize(), frame);
    }

    @Override
    public void applyProperties(Size size) {
        CustomSize customSize = (CustomSize) size;
        selectPosition(customSize.getPosition());
        selectRepeat(customSize.getRepeat());
        this.size.get().setValue(((CustomSize) size).getFill());
    }

}
