package com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.url.link_to;

import com.brizy.io.web.common.dto.element.properties.button.link.url.link_to.LinkToProperties;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.variations.button.link.url.link_to.population.Population;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.toolbar.link.tabs.url.link_to.LinkToLocators;
import com.microsoft.playwright.Frame;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Objects;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class LinkTo {

    Supplier<Population> population;
    Supplier<TextInput> link;

    public LinkTo(LinkToLocators linkTo, Frame frame) {
        this.link = () -> new TextInput(frame.locator(linkTo.getValue()));
        this.population = () -> new Population(linkTo.getPopulation(), frame);
    }


    public void applyProperties(LinkToProperties linkTo) {
        if (Objects.nonNull(linkTo.getValue())) {
            link.get().fill(linkTo.getValue());
        }
        if (Objects.nonNull(linkTo.getPopulation())) {
            population.get().applyProperties(linkTo.getPopulation());
        }
    }

}
