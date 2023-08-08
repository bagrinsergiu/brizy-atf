package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.size;

import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.FitSize;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.Size;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.tabs.mask.MaskProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Fit extends AbstractFitSize {

    public Fit(MaskProperties mask, Frame frame) {
        super(mask, frame);
    }

    @Override
    public void applyProperties(Size size) {
        FitSize fitSizeProperties = (FitSize) size;
        selectPosition(fitSizeProperties.getPosition());
        selectRepeat(fitSizeProperties.getRepeat());
    }

}
