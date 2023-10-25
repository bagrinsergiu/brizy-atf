package com.brizy.io.web.interactions.page.publish.section;

import com.brizy.io.web.interactions.locators.publish.section.SectionLocators;
import com.brizy.io.web.interactions.locators.publish.section.container.item.PublishedItemLocators;
import com.brizy.io.web.interactions.page.common.GenericComponent;
import com.brizy.io.web.interactions.page.factory.ComponentsFactory;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class Section {

    String uuidAttribute = "id";
    @Getter
    String uuid;
    Map<String, GenericComponent> sectionComponents;
    Locator sectionLocator;
    PublishedItemLocators publishedItemLocators;

    public Section(SectionLocators sectionLocators, Page page, Locator locator) {
        this.sectionLocator = locator;
        this.uuid = locator.getAttribute(uuidAttribute);
        this.sectionComponents = new HashMap<>();
        this.publishedItemLocators = sectionLocators.getContainer().getItem();
    }

    public <T extends GenericComponent> List<T> getComponents() {
        return sectionLocator.locator(publishedItemLocators.getSelf()).all().stream()
                .map(component -> ComponentsFactory.getComponentByType(component, publishedItemLocators))
                .map(component -> (T) component)
                .collect(Collectors.toList());
    }

}