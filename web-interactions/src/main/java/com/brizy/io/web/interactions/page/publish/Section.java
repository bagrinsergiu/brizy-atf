package com.brizy.io.web.interactions.page.publish;

import com.brizy.io.web.interactions.page.common.GenericComponent;
import com.brizy.io.web.interactions.page.factory.ComponentsFactory;
import com.brizy.io.web.interactions.locators.publish.SectionProperties;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Section {

    @Getter
    String uuid;
    Map<String, GenericComponent> sectionComponents;
    Locator sectionLocator;
    String addedItemsLocator;

    public Section(SectionProperties sectionProperties, Page page, Locator locator) {
        this.sectionLocator = locator;
        this.uuid = locator.getAttribute("data-uid");
        this.sectionComponents = new HashMap<>();
        this.addedItemsLocator = sectionProperties.getContainer().getItem().getSelf();
    }

    public <T extends GenericComponent> List<T> getComponents() {
        return sectionLocator.locator(addedItemsLocator).all().stream()
                .map(component -> ComponentsFactory.getComponentByType(component))
                .map(component -> (T) component)
                .collect(Collectors.toList());
    }

}