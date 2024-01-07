package com.brizy.io.web.interactions.page.editor.container;

import com.brizy.io.web.interactions.exception.SectionNotFoundException;
import com.brizy.io.web.interactions.locators.editor.workspace.WorkspaceLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.SectionLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.Duration;
import java.util.*;
import java.util.function.Supplier;

import static org.awaitility.Awaitility.await;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Page {

    @Getter
    Map<String, Section> sections;
    Supplier<List<Locator>> allSections;
    SectionLocators sectionLocators;
    Frame frame;

    public Page(WorkspaceLocators workspace, Frame page) {
        this.frame = page;
        this.sections = new HashMap<>();
        this.sectionLocators = workspace.getSection();
        this.allSections = () -> page.locator(sectionLocators.getSelf()).all();
    }

    public Section getSection(String sectionName) {
        return Optional.of(sections.get(sectionName))
                .orElseThrow(() -> new SectionNotFoundException(String.format("Element with name %s was not found on page", sectionName)));
    }

    public Section addSection(String name) {
        return sections.put(name, getNewlyAddedSection());
    }

    private Section getNewlyAddedSection() {
        waitForSections();
        return allSections.get().stream()
                .filter(this::isUnknownSection)
                .findFirst()
                .map(foundSectionLocator -> new Section(sectionLocators, frame, foundSectionLocator))
                .orElseThrow(() -> new SectionNotFoundException("Expected to have at least one section"));
    }

    private boolean isUnknownSection(Locator sectionLocator) {
        return sections.values().stream()
                .noneMatch(section -> section.getUuid().equals(getAttributeTillNotNull(sectionLocator)));
    }

    private String getAttributeTillNotNull(Locator locator) {
        return await().atMost(Duration.ofSeconds(30))
                .with().pollInterval(Duration.ofMillis(100))
                .until(() -> locator.getAttribute("data-brz-uid"), Objects::nonNull);
    }

    private void waitForSections() {
        await().atMost(Duration.ofSeconds(30))
                .with().pollInterval(Duration.ofMillis(100))
                .until(() -> !allSections.get().isEmpty());
    }

}
