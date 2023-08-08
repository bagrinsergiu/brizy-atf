package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask;

import com.brizy.io.web.common.dto.element.properties.toolbar.image.mask.Mask;
import com.brizy.io.web.common.dto.element.properties.toolbar.image.mask.shape.AnyPredefinedMask;
import com.brizy.io.web.common.dto.element.properties.toolbar.image.mask.shape.CustomMask;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.shape.CustomShape;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.shape.PredefinedShape;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.tabs.mask.MaskProperties;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MaskTab {

    Supplier<Button> maskTabButton;
    Supplier<ComboBox> shapeComboBox;
    Supplier<CustomShape> customShape;
    Supplier<PredefinedShape> predefinedShape;

    public MaskTab(MaskProperties mask, Frame frame) {
        this.maskTabButton = () -> new Button(frame.locator(mask.getSelf()));
        this.shapeComboBox = () -> new ComboBox(frame.locator(mask.getShape()));
        this.customShape = () -> new CustomShape(mask, frame);
        this.predefinedShape = () -> new PredefinedShape(mask, frame);
    }

    public void applyProperties(Mask mask) {
        maskTabButton.get().click();
        if (mask.getShape() instanceof AnyPredefinedMask shapeProperties) {
            shapeComboBox.get().selectItemByValue(shapeProperties.getShape());
            predefinedShape.get().applyProperties(shapeProperties);
        } else if (mask.getShape() instanceof CustomMask customMask) {
            shapeComboBox.get().selectItemByName(customMask.getShape());
            customShape.get().applyProperties(((CustomMask) mask.getShape()));
        } else
            shapeComboBox.get().selectItemByName("None");
    }

}
