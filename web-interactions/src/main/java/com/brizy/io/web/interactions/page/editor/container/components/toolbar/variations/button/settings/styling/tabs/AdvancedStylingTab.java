package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.styling.tabs;

import com.brizy.io.web.common.dto.element.properties.button.settings.styling.advanced.AdvancedStylingProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.element.composite.InputWithPopulation;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.styling.advanced.AdvancedStylingLocators;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AdvancedStylingTab {

    @Getter
    Supplier<Button> tabButton;
    Supplier<Slider> showOnDesktop;
    Supplier<NumericInput> zIndex;
    Supplier<InputWithPopulation> cssId;
    Supplier<InputWithPopulation> cssClass;
    Supplier<InputWithPopulation> customAttribute;
    Supplier<TextInput> customCss;
    Supplier<NumericInput> hoverTransition;

    public AdvancedStylingTab(AdvancedStylingLocators advancedStylingLocators, Page frame) {
        this.tabButton = () -> new Button(frame.locator(advancedStylingLocators.getSelf()));
        this.showOnDesktop = () -> new Slider(frame.locator(advancedStylingLocators.getShowOnDesktop()));
        this.cssId = () -> new InputWithPopulation(advancedStylingLocators.getCssId(), frame);
        this.cssClass = () -> new InputWithPopulation(advancedStylingLocators.getCssClass(), frame);
        this.customAttribute = () -> new InputWithPopulation(advancedStylingLocators.getCustomAttribute(), frame);
        this.customCss = () -> new TextInput(frame.locator(advancedStylingLocators.getCustomCss().getValue()));
        this.hoverTransition = () -> new NumericInput(frame.locator(advancedStylingLocators.getHoverTransition()));
        this.zIndex = () -> new NumericInput(frame.locator(advancedStylingLocators.getZIndex()));
    }

    public void applyProperties(AdvancedStylingProperties advancedStylingProperties) {
        tabButton.get().click();
        if (Objects.nonNull(advancedStylingProperties.getShowOnDesktop())) {
            this.showOnDesktop.get().switchTo(advancedStylingProperties.getShowOnDesktop());
        }
        if (Objects.nonNull(advancedStylingProperties.getCssId())) {
            cssId.get().setValue(advancedStylingProperties.getCssId());
        }
        if (Objects.nonNull(advancedStylingProperties.getCssClass())) {
            cssClass.get().setValue(advancedStylingProperties.getCssClass());
        }
        if (Objects.nonNull(advancedStylingProperties.getCustomAttributes())) {
            customAttribute.get().setValue(advancedStylingProperties.getCustomAttributes());
        }
        if (Objects.nonNull(advancedStylingProperties.getCustomCss()) && !advancedStylingProperties.getCustomCss().isEmpty()) {
            customCss.get().fill(advancedStylingProperties.getCustomCss());
        }
        if (Objects.nonNull(advancedStylingProperties.getHoverTransition())) {
            hoverTransition.get().fill(advancedStylingProperties.getHoverTransition());
        }
        if (Objects.nonNull(advancedStylingProperties.getZIndex())) {
            zIndex.get().fill(advancedStylingProperties.getZIndex());
        }
    }

    public AdvancedStylingProperties getProperties() {
        tabButton.get().click();
        return AdvancedStylingProperties.builder()
                .cssClass(cssClass.get().getValue())
                .cssId(cssId.get().getValue())
                .customAttributes(customAttribute.get().getValue())
//                .customCss(customCss.get().getText())
                .customCss(StringUtils.EMPTY)
                .hoverTransition(Integer.valueOf(hoverTransition.get().getText()))
                .showOnDesktop(showOnDesktop.get().getState())
                .zIndex(Integer.valueOf(zIndex.get().getText()))
                .build();
    }

}
