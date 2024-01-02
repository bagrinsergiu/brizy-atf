package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.mask;

import com.brizy.io.web.common.dto.element.properties.image.image.mask.Mask;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.shape.AnyPredefinedMask;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.shape.CustomMask;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.shape.NoneMask;
import com.brizy.io.web.common.dto.element.properties.image.image.mask.shape.Shape;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.Configuration;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.image.tabs.mask.MaskLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.tabs.AbstractTabItem;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.mask.shape.CustomShape;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.image.image.mask.shape.PredefinedShape;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@FieldNameConstants
public class MaskTab extends AbstractTabItem {

    Supplier<ComboBox> shape;
    Supplier<CustomShape> customShape;
    Supplier<PredefinedShape> predefinedShape;

    public MaskTab(MaskLocators mask, Frame frame) {
        super(mask.getConfigurations(), mask.getSelf(), frame);
        this.shape = () -> new ComboBox(frame.locator(mask.getShape()));
        this.customShape = () -> new CustomShape(mask, frame);
        this.predefinedShape = () -> new PredefinedShape(mask, frame);
    }

    public void applyProperties(Mask mask) {
        open();
        if (mask.getShape() instanceof AnyPredefinedMask shapeProperties) {
            shape.get().selectItemByValue(shapeProperties.getShape());
            predefinedShape.get().applyProperties(shapeProperties);
        } else if (mask.getShape() instanceof CustomMask customMask) {
            shape.get().selectItemByName(customMask.getShape());
            customShape.get().applyProperties(((CustomMask) mask.getShape()));
        } else
            shape.get().selectItemByName("None");
    }

    @Override
    public List<Configuration> getConfigurations() {
        open();
        String selectedItem = shape.get().getSelectedItem();
        List<Configuration> defaultConfigurations = new ArrayList<>() {{
            add(Configuration.builder().name(Fields.shape).element(shape).build());
        }};
        if (selectedItem.equalsIgnoreCase("custom")) {
            defaultConfigurations.addAll(customShape.get().getConfigurations());
        }
        if (!List.of("none", "custom").contains(selectedItem.toLowerCase())) {
            defaultConfigurations.addAll(predefinedShape.get().getConfigurations());
        }
        return defaultConfigurations;
    }

    public Mask getProperties() {
        open();
        Shape selectedShape;
        String selectedItem = shape.get().getInnerHtmlSelectedValue();
        if (selectedItem.equalsIgnoreCase("none")) {
            selectedShape = NoneMask.builder().shape(selectedItem).build();
        } else if (selectedItem.equalsIgnoreCase("custom")) {
            selectedShape = customShape.get().getProperties().toBuilder().shape(selectedItem).build();
        } else {
            selectedShape = predefinedShape.get().getProperties().toBuilder().shape(selectedItem).build();
        }
        return Mask.builder()
                .shape(selectedShape)
                .build();
    }
}
