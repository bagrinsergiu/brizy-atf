package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.styling.tabs.basic.padding;

import com.brizy.io.web.common.dto.element.properties.button.settings.styling.basic.padding.PaddingProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.styling.basic.padding.types.AllPaddingsProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.styling.basic.padding.types.IndividualPaddingProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.styling.enums.PaddingTypes;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.padding.PaddingLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.padding.spacing.SpacingLocators;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.padding.spacing.individual.IndividualSpacingLocators;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PaddingSettings {

    Supplier<RadioControl<PaddingTypes>> paddingControl;
    Supplier<InputWithUnits> paddingValue;
    Supplier<InputWithUnits> topPaddingValue;
    Supplier<InputWithUnits> bottomPaddingValue;
    Supplier<InputWithUnits> leftPaddingValue;
    Supplier<InputWithUnits> rightPaddingValue;

    public PaddingSettings(PaddingLocators paddingLocators, Page frame) {
        SpacingLocators spacing = paddingLocators.getSpacing();
        IndividualSpacingLocators individualSpacingLocators = spacing.getIndividual();
        this.paddingControl = () -> new RadioControl<>(PaddingTypes.class, paddingLocators.getItems(), frame);
        this.paddingValue = () -> new InputWithUnits(spacing.getAll(), frame);
        this.topPaddingValue = () -> new InputWithUnits(individualSpacingLocators.getTop(), frame);
        this.bottomPaddingValue = () -> new InputWithUnits(individualSpacingLocators.getBottom(), frame);
        this.leftPaddingValue = () -> new InputWithUnits(individualSpacingLocators.getLeft(), frame);
        this.rightPaddingValue = () -> new InputWithUnits(individualSpacingLocators.getRight(), frame);
    }

    public void applyProperties(PaddingProperties paddingProperties) {
        if (paddingProperties instanceof AllPaddingsProperties allPaddingsProperties) {
            paddingControl.get().set(PaddingTypes.ALL);
            paddingValue.get().setValue(allPaddingsProperties.getSize());
        }
        if (paddingProperties instanceof IndividualPaddingProperties individualPaddingProperties) {
            paddingControl.get().set(PaddingTypes.INDIVIDUAL);
            topPaddingValue.get().setValue(individualPaddingProperties.getTop());
            bottomPaddingValue.get().setValue(individualPaddingProperties.getBottom());
            leftPaddingValue.get().setValue(individualPaddingProperties.getLeft());
            rightPaddingValue.get().setValue(individualPaddingProperties.getRight());
        }
    }

    public PaddingProperties getProperties() {
        PaddingTypes activeValue = paddingControl.get().getActiveControl();
        if (activeValue.equals(PaddingTypes.ALL)) {
            return AllPaddingsProperties.builder()
                    .size(paddingValue.get().getValue())
                    .value(activeValue.getValue())
                    .build();
        } else {
            return IndividualPaddingProperties.builder()
                    .bottom(bottomPaddingValue.get().getValue())
                    .left(leftPaddingValue.get().getValue())
                    .right(rightPaddingValue.get().getValue())
                    .top(topPaddingValue.get().getValue())
                    .value(activeValue.getValue())
                    .build();
        }
    }
}
