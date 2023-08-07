package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.shape;

import com.brizy.io.web.common.dto.element.properties.toolbar.image.mask.shape.AnyPredefinedMask;
import com.brizy.io.web.common.dto.element.properties.toolbar.image.mask.size.FillSize;
import com.brizy.io.web.common.dto.element.properties.toolbar.image.mask.size.FitSize;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.size.Custom;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.size.Fill;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.size.Fit;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.tabs.mask.MaskProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PredefinedShape {

    Supplier<ComboBox> sizeComboBox;
    Supplier<Fill> fillSize;
    Supplier<Fit> fitSize;
    Supplier<Custom> customSize;

    public PredefinedShape(MaskProperties mask, Frame frame) {
        this.sizeComboBox = () -> new ComboBox(frame.locator(mask.getSize().getSelf()));
        this.fillSize = () -> new Fill(mask, frame);
        this.fitSize = () -> new Fit(mask, frame);
        this.customSize = () -> new Custom(mask, frame);
    }

    public void applyProperties(AnyPredefinedMask shapeProperties) {
        if (shapeProperties.getSize() instanceof FitSize fitSizeProperties) {
            sizeComboBox.get().selectItemByName("Fit");
            fitSize.get().applyProperties(fitSizeProperties);
        } else if (shapeProperties.getSize() instanceof FillSize fillSizeProperties) {
            sizeComboBox.get().selectItemByName("Fill");
            fillSize.get().applyProperties(fillSizeProperties);
        } else {
            sizeComboBox.get().selectItemByName("Custom");
            customSize.get().applyProperties(shapeProperties.getSize());
        }
    }

}
