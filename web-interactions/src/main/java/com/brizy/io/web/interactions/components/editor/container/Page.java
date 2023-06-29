package com.brizy.io.web.interactions.components.editor.container;

import com.brizy.io.web.interactions.exception.SectionNotFoundException;
import com.brizy.io.web.interactions.properties.editor.workspace.WorkspaceProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.SectionProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Page {

    @Getter
    Map<String, Section> sections;
    Supplier<List<Locator>> allSections;
    SectionProperties sectionProperties;
    Frame frame;

    public Page(WorkspaceProperties workspace, Frame page) {
        this.frame = page;
        this.sections = new HashMap<>();
        this.sectionProperties = workspace.getSection();
        this.allSections = () -> page.locator(sectionProperties.getSelf()).all();
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
                .map(foundSectionLocator -> new Section(sectionProperties, frame, foundSectionLocator))
                .orElseThrow(() -> new SectionNotFoundException("Expected to have at least one section"));
    }

    private boolean isUnknownSection(Locator sectionLocator) {
        return sections.values().stream()
                .noneMatch(section -> section.getUuid().equals(getAttributeTillNotNull(sectionLocator, "data-uid")));
    }

    //    TODO refactor to separate class
    private String getAttributeTillNotNull(Locator locator, String attribute) {
        LocalDateTime now = LocalDateTime.now();
        while (LocalDateTime.now().getSecond() - now.getSecond() < 10) ;
        return locator.getAttribute(attribute);
    }

    //    TODO refactor to sepra
    private void waitForSections() {
        while (allSections.get().size() == 0) ;
    }

}
