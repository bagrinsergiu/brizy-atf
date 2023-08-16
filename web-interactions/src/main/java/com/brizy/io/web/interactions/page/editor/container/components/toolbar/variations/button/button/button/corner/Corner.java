package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.button.button.corner;

import com.brizy.io.web.common.dto.element.properties.button.button.button.corner.ConcreteCorner;
import com.brizy.io.web.common.dto.element.properties.button.button.button.corner.CornerProperties;
import com.brizy.io.web.common.dto.element.properties.button.button.button.corner.CornerTypes;
import com.brizy.io.web.common.dto.element.properties.button.button.button.corner.CustomCorner;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.element.composite.EnumerableButton;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.button.tabs.button.corner.CornerLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Corner {

    Supplier<RadioControl<CornerTypes>> corner;
    Supplier<NumericInput> radius;

    public Corner(CornerLocators cornerLocators, Frame frame) {
        this.corner = () -> new RadioControl<>(CornerTypes.class, cornerLocators.getSelf(), frame);
        this.radius = () -> new NumericInput(frame.locator(cornerLocators.getCustom().getRadiusValue()));
    }

    public void applyProperties(CornerProperties cornerProperties) {
        if (cornerProperties instanceof CustomCorner customCorner) {
            corner.get().set(CornerTypes.CUSTOM);
            radius.get().fill(customCorner.getCorner().getAngle());
        } else {
            corner.get().set(((ConcreteCorner)cornerProperties).getCorner());
        }
    }
}
