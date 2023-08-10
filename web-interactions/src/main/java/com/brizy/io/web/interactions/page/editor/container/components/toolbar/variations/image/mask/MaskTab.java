package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask;

import com.brizy.io.web.common.dto.element.properties.image.image.mask.Mask;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.shape.AnyPredefinedMask;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.shape.CustomMask;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.IsTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.ImageTab;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.shape.CustomShape;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.mask.shape.PredefinedShape;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.image.tabs.mask.MaskProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class MaskTab implements IsTab {

    Supplier<Button> maskTabButton;
    Supplier<ComboBox> shapeComboBox;
    Supplier<CustomShape> customShape;
    Supplier<PredefinedShape> predefinedShape;
    Supplier<Locator> configurations;

    public MaskTab(MaskProperties mask, Frame frame) {
        this.configurations = () -> frame.locator(mask.getConfigurations());
        this.maskTabButton = () -> new Button(frame.locator(mask.getSelf()));
        this.shapeComboBox = () -> new ComboBox(frame.locator(mask.getShape()));
        this.customShape = () -> new CustomShape(mask, frame);
        this.predefinedShape = () -> new PredefinedShape(mask, frame);
    }

    public void open() {
        maskTabButton.get().click();
    }

    public void applyProperties(Mask mask) {
        open();
        if (mask.getShape() instanceof AnyPredefinedMask shapeProperties) {
            shapeComboBox.get().selectItemByValue(shapeProperties.getShape());
            predefinedShape.get().applyProperties(shapeProperties);
        } else if (mask.getShape() instanceof CustomMask customMask) {
            shapeComboBox.get().selectItemByName(customMask.getShape());
            customShape.get().applyProperties(((CustomMask) mask.getShape()));
        } else
            shapeComboBox.get().selectItemByName("None");
    }

    @Override
    public List<String> getWebConfigurations() {
        return configurations.get().all().stream()
                .map(Locator::textContent)
                .toList();
    }

    @Override
    public List<Configuration> getConfigurations() {
        return List.of(
                Configuration.builder().name(MaskTab.Fields.shapeComboBox).element(shapeComboBox).build()
        );
    }

}
