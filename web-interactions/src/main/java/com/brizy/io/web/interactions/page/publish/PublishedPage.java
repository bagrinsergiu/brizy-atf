package com.brizy.io.web.interactions.page.publish;

import com.brizy.io.web.interactions.page.AbstractPage;
import com.brizy.io.web.interactions.locators.publish.PublishPageProperties;
import com.brizy.io.web.interactions.locators.publish.SectionProperties;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PublishedPage extends AbstractPage {

    Map<String, Section> sections;
    Supplier<List<Locator>> allSectionsLocators;
    Function<Locator, Section> getSectionFromLocator;

    public PublishedPage(PublishPageProperties publishedPageProperties, com.microsoft.playwright.Page page) {
        super(page);
        SectionProperties sectionProperties = publishedPageProperties.getSection();
        this.sections = new HashMap<>();
        this.allSectionsLocators = () -> page.locator(sectionProperties.getSelf()).all();
        this.getSectionFromLocator = foundSectionLocator -> new Section(sectionProperties, page, foundSectionLocator);
    }

    public List<Section> getSections() {
        waitForSections();
        return allSectionsLocators.get().stream()
                .map(getSectionFromLocator)
                .collect(Collectors.toList());
    }

    //    TODO refactor to sepra
    private void waitForSections() {
        while (allSectionsLocators.get().size() == 0) ;
    }

}
