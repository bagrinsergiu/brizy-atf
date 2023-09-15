package com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.effects.tabs;

import com.brizy.io.web.common.dto.element.properties.common.settings.settings.effects.entrance.EntranceProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.settings.effects.entrance.types.AnyEntranceParametersProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.settings.effects.entrance.types.AnyEntranceProperties;
import com.brizy.io.web.common.dto.element.properties.common.settings.settings.effects.entrance.types.NoneEntranceProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.element.Slider;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.common.settings.effects.EffectsGrid;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.effects.entrance.EntranceLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.effects.entrance.properties.EntrancePropertiesLocators;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class EntranceTab {

    Supplier<Button> tab;
    Supplier<EffectsGrid> grid;
    Supplier<ComboBox> direction;
    Supplier<Slider> big;
    Supplier<NumericInput> duration;
    Supplier<NumericInput> delay;
    Supplier<Slider> infiniteAnimation;

    public EntranceTab(EntranceLocators entranceLocators, Page page) {
        this.grid = () -> new EffectsGrid(entranceLocators.getGrid(), page);
        this.tab = () -> new Button(page.locator(entranceLocators.getSelf()));
        EntrancePropertiesLocators entrancePropertiesLocators = entranceLocators.getProperties();
        this.direction = () -> new ComboBox(page.locator(entrancePropertiesLocators.getDirection()));
        this.big = () -> new Slider(page.locator(entrancePropertiesLocators.getBig()));
        this.duration = () -> new NumericInput(page.locator(entrancePropertiesLocators.getDuration()));
        this.delay = () -> new NumericInput(page.locator(entrancePropertiesLocators.getDelay()));
        this.infiniteAnimation = () -> new Slider(page.locator(entrancePropertiesLocators.getInfiniteAnimation()));
    }

    public void applyProperties(EntranceProperties entranceProperties) {
        tab.get().click();
        grid.get().select(entranceProperties.getValue());
        if (entranceProperties instanceof AnyEntranceProperties aneEntranceProperties) {
            AnyEntranceParametersProperties parameters = aneEntranceProperties.getParameters();
            if (Objects.nonNull(parameters)) {
                if (Objects.nonNull(parameters.getDirection())) {
                    direction.get().selectItemByValue(parameters.getDirection());
                }
                if (Objects.nonNull(parameters.getBig())) {
                    big.get().switchTo(parameters.getBig());
                }
                if (Objects.nonNull(parameters.getDuration())) {
                    duration.get().fill(parameters.getDuration());
                }
                if (Objects.nonNull(parameters.getDelay())) {
                    delay.get().fill(parameters.getDelay());
                }
                if (Objects.nonNull(parameters.getInfiniteAnimation())) {
                    infiniteAnimation.get().switchTo(parameters.getInfiniteAnimation());
                }
            }
        }
    }

    public EntranceProperties getProperties() {
        tab.get().click();
        String activeGridItem = grid.get().getActiveItem();
        if (activeGridItem.equals("None")) {
            return NoneEntranceProperties.builder().value(activeGridItem).build();
        } else {
            return AnyEntranceProperties.builder()
                    .value(activeGridItem)
                    .parameters(AnyEntranceParametersProperties.builder()
                            .big(big.get().getState())
                            .delay(Integer.valueOf(delay.get().getText()))
                            .direction(direction.get().getSelectedItem())
                            .duration(Double.valueOf(duration.get().getText()))
                            .infiniteAnimation(infiniteAnimation.get().getState())
                            .build())
                    .build();
        }
    }
}
