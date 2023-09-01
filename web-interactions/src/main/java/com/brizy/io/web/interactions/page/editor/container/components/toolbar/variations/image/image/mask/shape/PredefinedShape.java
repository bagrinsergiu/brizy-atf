package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.mask.shape;

import com.brizy.io.web.common.dto.element.properties.image.image.mask.shape.AnyPredefinedMask;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.FillSize;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.FitSize;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.size.Size;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.tabs.mask.MaskProperties;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.mask.size.Custom;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.mask.size.Fill;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.mask.size.Fit;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@FieldNameConstants
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PredefinedShape {

    Supplier<ComboBox> size;
    Supplier<Fill> fillSize;
    Supplier<Fit> fitSize;
    Supplier<Custom> customSize;

    public PredefinedShape(MaskProperties mask, Frame frame) {
        this.size = () -> new ComboBox(frame.locator(mask.getSize().getSelf()));
        this.fillSize = () -> new Fill(mask, frame);
        this.fitSize = () -> new Fit(mask, frame);
        this.customSize = () -> new Custom(mask, frame);
    }

    public void applyProperties(AnyPredefinedMask shapeProperties) {
        if (shapeProperties.getSize() instanceof FitSize fitSizeProperties) {
            size.get().selectItemByName("Fit");
            fitSize.get().applyProperties(fitSizeProperties);
        } else if (shapeProperties.getSize() instanceof FillSize fillSizeProperties) {
            size.get().selectItemByName("Fill");
            fillSize.get().applyProperties(fillSizeProperties);
        } else {
            size.get().selectItemByName("Custom");
            customSize.get().applyProperties(shapeProperties.getSize());
        }
    }

    public List<Configuration> getConfigurations() {
        ComboBox comboBox = size.get();
        List<Configuration> configurationsToReturn = new ArrayList<>() {{
            add(Configuration.builder().name(Fields.size).element(size).build());
        }};
        if (comboBox.getSelectedItem().equalsIgnoreCase("fill")) {
            configurationsToReturn.addAll(fillSize.get().getConfigurations());
        } else if (comboBox.getSelectedItem().equalsIgnoreCase("fit")) {
            configurationsToReturn.addAll(fitSize.get().getConfigurations());
        } else if (comboBox.getSelectedItem().equalsIgnoreCase("custom")) {
            configurationsToReturn.addAll(customSize.get().getConfigurations());
        }
        return configurationsToReturn;
    }

    public AnyPredefinedMask getProperties() {
        Size selectedSize;
        String selectedItem = size.get().getSelectedItem();
        if (selectedItem.equalsIgnoreCase("fill")) {
            selectedSize = fillSize.get().getProperties().toBuilder().type(selectedItem).build();
        } else if (selectedItem.equalsIgnoreCase("fit")) {
            selectedSize = fitSize.get().getProperties().toBuilder().build();
        } else {
            selectedSize = customSize.get().getProperties();
        }
        return AnyPredefinedMask.builder()
                .size(selectedSize)
                .build();
    }
}
