package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.scrollbar.styling.tabs.basic.margin;

import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.margin.MarginProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.margin.types.AllMarginsProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.basic.margin.types.IndividualMarginProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.scrollbar.styling.enums.MarginTypes;
import com.brizy.io.web.interactions.element.composite.InputWithUnits;
import com.brizy.io.web.interactions.element.composite.RadioControl;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.margin.MarginLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.margin.spacing.SpacingLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.basic.margin.spacing.individual.IndividualSpacingLocators;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MarginSettings {

    Supplier<RadioControl<MarginTypes>> marginControl;
    Supplier<InputWithUnits> marginValue;
    Supplier<InputWithUnits> topMarginValue;
    Supplier<InputWithUnits> bottomMarginValue;
    Supplier<InputWithUnits> leftMarginValue;
    Supplier<InputWithUnits> rightMarginValue;

    public MarginSettings(MarginLocators marginLocators, Page frame) {
        SpacingLocators spacing = marginLocators.getSpacing();
        IndividualSpacingLocators individualSpacingLocators = spacing.getIndividual();
        this.marginControl = () -> new RadioControl<>(MarginTypes.class, marginLocators.getItems(), frame);
        this.marginValue = () -> new InputWithUnits(spacing.getAll(), frame);
        this.topMarginValue = () -> new InputWithUnits(individualSpacingLocators.getTop(), frame);
        this.bottomMarginValue = () -> new InputWithUnits(individualSpacingLocators.getBottom(), frame);
        this.leftMarginValue = () -> new InputWithUnits(individualSpacingLocators.getLeft(), frame);
        this.rightMarginValue = () -> new InputWithUnits(individualSpacingLocators.getRight(), frame);
    }

    public void applyProperties(MarginProperties marginProperties) {
        if (marginProperties instanceof AllMarginsProperties allMarginsProperties) {
            marginControl.get().set(MarginTypes.ALL);
            marginValue.get().setValue(allMarginsProperties.getSize());
        }
        if (marginProperties instanceof IndividualMarginProperties individualMarginProperties) {
            marginControl.get().set(MarginTypes.INDIVIDUAL);
            topMarginValue.get().setValue(individualMarginProperties.getTop());
            bottomMarginValue.get().setValue(individualMarginProperties.getBottom());
            leftMarginValue.get().setValue(individualMarginProperties.getLeft());
            rightMarginValue.get().setValue(individualMarginProperties.getRight());
        }
    }

    public MarginProperties getProperties() {
        MarginTypes activeValue = marginControl.get().getActiveControl();
        if (activeValue.equals(MarginTypes.ALL)) {
            return AllMarginsProperties.builder()
                    .size(marginValue.get().getValue())
                    .value(activeValue.getValue())
                    .build();
        } else {
            return IndividualMarginProperties.builder()
                    .bottom(bottomMarginValue.get().getValue())
                    .left(leftMarginValue.get().getValue())
                    .right(rightMarginValue.get().getValue())
                    .top(topMarginValue.get().getValue())
                    .value(activeValue.getValue())
                    .build();
        }
    }
}
