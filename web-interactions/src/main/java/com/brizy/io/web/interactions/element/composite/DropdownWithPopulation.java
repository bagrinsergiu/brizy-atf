package com.brizy.io.web.interactions.element.composite;

import com.brizy.io.web.common.dto.element.properties.common.DropdownWithPopulationProperties;
import com.brizy.io.web.common.dto.element.properties.common.PopulationProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.ComboBox;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.InputWithPopulationLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class DropdownWithPopulation {

    Supplier<Button> populationButton;
    Supplier<List<Locator>> populationItems;
    Supplier<ComboBox> value;

    public DropdownWithPopulation(InputWithPopulationLocators locators, Frame frame) {
        this.value = () -> new ComboBox(frame.locator(locators.getValue()));
        this.populationButton = () -> new Button(frame.locator(locators.getPopulation().getSelf()));
        this.populationItems = () -> frame.locator(locators.getPopulation().getItems()).all();
    }

    public DropdownWithPopulation(InputWithPopulationLocators locators, Page page) {
        this.value = () -> new ComboBox(page.locator(locators.getValue()));
        this.populationButton = () -> new Button(page.locator(locators.getPopulation().getSelf()));
        this.populationItems = () -> page.locator(locators.getPopulation().getItems()).all();
    }

    public String getInputValue() {
        return value.get().getSelectedItem();
    }

    public DropdownWithPopulationProperties getValue() {
        return DropdownWithPopulationProperties.builder()
                .value(value.get().getSelectedItem())
                .population(getSelectedPopulation())
                .build();
    }

    public void setValue(DropdownWithPopulationProperties properties) {
        if (Objects.nonNull(properties.getValue()) && !properties.getValue().isEmpty() && !properties.getValue().isBlank()) {
            value.get().selectItemByName(properties.getValue());
        }
        if (Objects.nonNull(properties.getPopulation())) {
            populationButton.get().click();
            populationItems.get().stream()
                    .filter(locator -> locator.getAttribute("title").equals(properties.getPopulation().getValue()))
                    .findFirst()
                    .ifPresent(Locator::click);
        }
    }

    private PopulationProperties getSelectedPopulation() {
        populationButton.get().click();
        var populationItems = this.populationItems.get().stream()
                .filter(el -> el.getAttribute("class").contains("active"))
                .findFirst()
                .map(Locator::textContent)
                .map(value -> PopulationProperties.builder().value(value).build())
                .orElse(PopulationProperties.builder().build());
        populationButton.get().click();
        return populationItems;
    }
}
