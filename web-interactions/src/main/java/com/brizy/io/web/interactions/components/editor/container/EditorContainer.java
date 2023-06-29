package com.brizy.io.web.interactions.components.editor.container;

import com.brizy.io.web.interactions.components.editor.container.components.Component;
import com.brizy.io.web.interactions.dto.editor.sidebar.SidebarItemDto;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.Div;
import com.brizy.io.web.interactions.enums.EditorSidebarElement;
import com.brizy.io.web.interactions.properties.editor.EditorFrameProperties;
import com.microsoft.playwright.Frame;
import io.vavr.control.Try;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class EditorContainer {

    Frame frame;
    Supplier<Button> addButton;
    @Getter
    Page page;

    public EditorContainer(EditorFrameProperties properties, com.microsoft.playwright.Page page) {
        this.frame = page.frame(properties.getName());
        this.page = new Page(properties.getWorkspace(), frame);
        this.addButton = () -> new Button(frame.locator(properties.getAddButton()));
    }

    public EditorContainer openPopUpMenu() {
        addButton.get().click();
        return this;
    }

    public EditorContainer addElements(List<SidebarItemDto> elements, Function<EditorSidebarElement, Div> findSidebarElementByType) {
        for (SidebarItemDto element : elements) {
            Div elementToCreate = findSidebarElementByType.apply(element.getType());
            Section sectionToAddElementTo = page.getSection(element.getSectionName());
            Component parentElement = Try.of(() -> sectionToAddElementTo.getComponentByName(element.getParentName())).getOrElse(() -> null);
            sectionToAddElementTo.addComponent(elementToCreate, parentElement, element);
        }
        return this;
    }

    public EditorContainer configureElements(List<SidebarItemDto> elements) {
        for (SidebarItemDto element : elements) {
            Section sectionToAddElementTo = page.getSection(element.getSectionName());
            Component foundComponent = sectionToAddElementTo.getComponentByName(element.getElementName());
            foundComponent.customize().withProperties(element.getComponentProperties());
            frame.page().mouse().click(100, 100);
        }
        return this;
    }

    public EditorContainer addSection(String sectionName) {
        page.addSection(sectionName);
        return this;
    }

}