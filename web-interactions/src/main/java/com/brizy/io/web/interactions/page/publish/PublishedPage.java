package com.brizy.io.web.interactions.page.publish;

import com.brizy.io.web.interactions.constants.TimingConstants;
import com.brizy.io.web.interactions.locators.publish.PublishPageLocators;
import com.brizy.io.web.interactions.locators.publish.section.SectionLocators;
import com.brizy.io.web.interactions.page.AbstractPage;
import com.brizy.io.web.interactions.page.publish.section.Section;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.awaitility.Awaitility.await;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PublishedPage extends AbstractPage {

    Supplier<List<Locator>> allSectionsLocators;
    Function<Locator, Section> getSectionFromLocator;

    public PublishedPage(PublishPageLocators publishedPageProperties, com.microsoft.playwright.Page page) {
        super(page);
        SectionLocators sectionLocators = publishedPageProperties.getSection();
        this.allSectionsLocators = () -> page.locator(sectionLocators.getSelf()).all();
        this.getSectionFromLocator = foundSectionLocator -> new Section(sectionLocators, page, foundSectionLocator);
    }

    public List<Section> getSections() {
        waitForSections();
        return allSectionsLocators.get().stream()
                .map(getSectionFromLocator)
                .collect(Collectors.toList());
    }

    public Section findSectionByUuid(String uuid) {
        return getSections().stream()
                .filter(section -> section.getUuid().equals(uuid))
                .findFirst()
                .orElseThrow();
    }

    private void waitForSections() {
        await().alias("Waiting for the sections to be available")
                .with().pollDelay(Duration.ofMillis(500))
                .and().atMost(TimingConstants.MAX_WAITING_TIME_FOR_FRAME_TO_LOAD)
                .until(() -> !allSectionsLocators.get().isEmpty());
    }

}
