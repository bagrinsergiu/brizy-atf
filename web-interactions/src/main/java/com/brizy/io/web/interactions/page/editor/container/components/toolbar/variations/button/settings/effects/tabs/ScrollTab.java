package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.effects.tabs;

import com.brizy.io.web.common.dto.element.properties.button.settings.effects.scroll.ScrollProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.effects.scroll.types.AnyScrollParametersProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.effects.scroll.types.AnyScrollProperties;
import com.brizy.io.web.common.dto.element.properties.button.settings.effects.scroll.types.NoneScrollProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.element.NumericInput;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.effects.scroll.ScrollLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.settings.scrollbar.tabs.effects.scroll.properties.ScrollPropertiesLocators;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.settings.effects.EffectsGrid;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ScrollTab {

    Supplier<Button> tab;
    Supplier<EffectsGrid> grid;
    Supplier<ComboBox> direction;
    Supplier<ComboBox> x;
    Supplier<ComboBox> y;
    Supplier<NumericInput> speed;
    Supplier<NumericInput> start;
    Supplier<NumericInput> stop;

    public ScrollTab(ScrollLocators scrollLocators, Page page) {
        this.tab = () -> new Button(page.locator(scrollLocators.getSelf()));
        this.grid = () -> new EffectsGrid(scrollLocators.getGrid(), page);
        ScrollPropertiesLocators scrollLocatorsProperties = scrollLocators.getProperties();
        this.direction = () -> new ComboBox(page.locator(scrollLocatorsProperties.getDirection()));
        this.x = () -> new ComboBox(page.locator(scrollLocatorsProperties.getX()));
        this.y = () -> new ComboBox(page.locator(scrollLocatorsProperties.getY()));
        this.speed = () -> new NumericInput(page.locator(scrollLocatorsProperties.getSpeed()));
        this.start = () -> new NumericInput(page.locator(scrollLocatorsProperties.getStart()));
        this.stop = () -> new NumericInput(page.locator(scrollLocatorsProperties.getStop()));
    }

    public void applyProperties(ScrollProperties scrollProperties) {
        tab.get().click();
        grid.get().select(scrollProperties.getValue());
        if (scrollProperties instanceof AnyScrollProperties anyScrollProperties) {
            AnyScrollParametersProperties parameters = anyScrollProperties.getParameters();
            if (Objects.nonNull(parameters)) {
                if (Objects.nonNull(parameters.getDirection())) {
                    direction.get().selectItemByValue(parameters.getDirection());
                }
                if (Objects.nonNull(parameters.getX())) {
                    x.get().selectItemByValue(parameters.getX());
                }
                if (Objects.nonNull(parameters.getY())) {
                    y.get().selectItemByValue(parameters.getY());
                }
                if (Objects.nonNull(parameters.getSpeed())) {
                    speed.get().fillAndWaitForValue(parameters.getSpeed());
                }
                if (Objects.nonNull(parameters.getStart())) {
                    start.get().fillAndWaitForValue(parameters.getStart());
                }
                if (Objects.nonNull(parameters.getStop())) {
                    stop.get().fillAndWaitForValue(parameters.getStop());
                }
            }
        }
    }

    public ScrollProperties getProperties() {
        tab.get().click();
        String activeGridItem = grid.get().getActiveItem();
        if (activeGridItem.equals("None")) {
            return NoneScrollProperties.builder().value(activeGridItem).build();
        } else {
            return AnyScrollProperties.builder()
                    .value(activeGridItem)
                    .parameters(AnyScrollParametersProperties.builder()
                            .direction(direction.get().getSelectedItem())
                            .x(x.get().getSelectedItem())
                            .y(y.get().getSelectedItem())
                            .speed(Integer.valueOf(speed.get().getText()))
                            .start(Integer.valueOf(start.get().getText()))
                            .stop(Integer.valueOf(stop.get().getRawValue()))
                            .build())
                    .build();
        }
    }
}
