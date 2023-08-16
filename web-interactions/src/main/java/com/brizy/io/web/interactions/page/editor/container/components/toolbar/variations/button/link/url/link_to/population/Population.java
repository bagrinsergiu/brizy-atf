package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.url.link_to.population;

import com.brizy.io.web.common.dto.element.properties.button.link.url.link_to.population.PopulationProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.url.link_to.population.PopulationLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Population {

    Supplier<Button> populationButton;
    Supplier<List<Locator>> populationItems;

    public Population(PopulationLocators populationLocators, Frame frame) {
        this.populationButton = () -> new Button(frame.locator(populationLocators.getSelf()));
        this.populationItems = () -> frame.locator(populationLocators.getItems()).all();
    }

    public void applyProperties(PopulationProperties population) {
        if (Objects.nonNull(population)) {
            populationButton.get().click();
            populationItems.get().stream()
                    .filter(locator -> locator.getAttribute("title").equals(population.getValue()))
                    .findFirst()
                    .ifPresent(Locator::click);
        }
    }
}
