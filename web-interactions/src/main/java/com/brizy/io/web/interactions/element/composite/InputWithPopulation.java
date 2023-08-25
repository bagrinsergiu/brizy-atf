package com.brizy.io.web.interactions.element.composite;

import com.brizy.io.web.common.dto.element.properties.common.PopulationProperties;
import com.brizy.io.web.common.dto.element.properties.common.InputWithPopulationProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.common.InputWithPopulationLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class InputWithPopulation {

    Supplier<Button> populationButton;
    Supplier<List<Locator>> populationItems;
    Supplier<TextInput> value;

    public InputWithPopulation(InputWithPopulationLocators locators, Frame frame) {
        this.value = () -> new TextInput(frame.locator(locators.getValue()));
        this.populationButton = () -> new Button(frame.locator(locators.getPopulation().getSelf()));
        this.populationItems = () -> frame.locator(locators.getPopulation().getItems()).all();
    }

    public InputWithPopulation(InputWithPopulationLocators locators, Page page) {
        this.value = () -> new TextInput(page.locator(locators.getValue()));
        this.populationButton = () -> new Button(page.locator(locators.getPopulation().getSelf()));
        this.populationItems = () -> page.locator(locators.getPopulation().getItems()).all();
    }

    public InputWithPopulationProperties getValue() {
        return InputWithPopulationProperties.builder()
                .value(value.get().getText())
                .population(getSelectedPopulation())
                .build();
    }

    public void setValue(InputWithPopulationProperties properties) {
        if (Objects.nonNull(properties.getValue()) && !properties.getValue().isEmpty() && !properties.getValue().isBlank()) {
            value.get().fill(properties.getValue());
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
        return populationItems.get().stream()
                .filter(el -> el.getAttribute("class").contains("active"))
                .findFirst()
                .map(Locator::textContent)
                .map(value -> PopulationProperties.builder().value(value).build())
                .orElse(PopulationProperties.builder().build());
    }
}
