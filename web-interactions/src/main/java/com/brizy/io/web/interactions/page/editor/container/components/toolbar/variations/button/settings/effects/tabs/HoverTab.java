package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.effects.tabs;

import com.brizy.io.web.common.dto.element.properties.button.settings.effects.hover.HoverProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.effects.hover.types.AnyHoverParametersProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.effects.hover.types.AnyHoverProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.effects.hover.types.NoneHoverProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.effects.hover.HoverLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.effects.hover.properties.HoverPropertiesLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.effects.EffectsGrid;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HoverTab {

    Supplier<Button> tab;
    Supplier<EffectsGrid> grid;
    Supplier<ComboBox> direction;
    Supplier<ComboBox> style;
    Supplier<NumericInput> duration;
    Supplier<Slider> infiniteAnimation;

    public HoverTab(HoverLocators hoverLocators, Page page) {
        this.tab = () -> new Button(page.locator(hoverLocators.getSelf()));
        this.grid = () -> new EffectsGrid(hoverLocators.getGrid(), page);
        HoverPropertiesLocators hoverPropertiesLocators = hoverLocators.getProperties();
        this.direction = () -> new ComboBox(page.locator(hoverPropertiesLocators.getDirection()));
        this.style = () -> new ComboBox(page.locator(hoverPropertiesLocators.getStyle()));
        this.duration = () -> new NumericInput(page.locator(hoverPropertiesLocators.getDuration()));
        this.infiniteAnimation = () -> new Slider(page.locator(hoverPropertiesLocators.getInfiniteAnimation()));
    }

    public void applyProperties(HoverProperties hoverProperties) {
        tab.get().click();
        grid.get().select(hoverProperties.getValue());
        if (hoverProperties instanceof AnyHoverProperties anyHoverProperties) {
            AnyHoverParametersProperties parameters = anyHoverProperties.getParameters();
            if (Objects.nonNull(parameters)) {
                if (Objects.nonNull(parameters.getDirection())) {
                    direction.get().selectItemByValue(parameters.getDirection());
                }
                if (Objects.nonNull(parameters.getStyle())) {
                    style.get().selectItemByValue(parameters.getStyle());
                }
                if (Objects.nonNull(parameters.getDuration())) {
                    duration.get().fill(parameters.getDuration());
                }
                if (Objects.nonNull(parameters.getInfiniteAnimation())) {
                    infiniteAnimation.get().switchTo(parameters.getInfiniteAnimation());
                }
            }
        }
    }

    public HoverProperties getProperties() {
        tab.get().click();
        String activeGridItem = grid.get().getActiveItem();
        if (activeGridItem.equals("None")) {
            return NoneHoverProperties.builder().value(activeGridItem).build();
        } else {
            return AnyHoverProperties.builder()
                    .value(activeGridItem)
                    .parameters(AnyHoverParametersProperties.builder()
                            .direction(direction.get().getSelectedItem())
                            .duration(Double.valueOf(duration.get().getText()))
                            .infiniteAnimation(infiniteAnimation.get().getState())
                            .style(style.get().getSelectedItem())
                            .build())
                    .build();
        }
    }
}
