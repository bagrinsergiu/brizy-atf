package com.brizy.io.web.interactions.components.editor.container;

import com.brizy.io.web.interactions.components.editor.container.components.Component;
import com.brizy.io.web.interactions.dto.editor.sidebar.SidebarItemDto;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.Div;
import com.brizy.io.web.interactions.enums.EditorSidebarElement;
import com.brizy.io.web.interactions.properties.editor.EditorFrameProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.options.LoadState;
import io.vavr.control.Try;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class EditorContainer {

    Frame frame;
    Supplier<Button> addButton;
    @Getter
    Page page;
    com.microsoft.playwright.Page mainPage;

    public EditorContainer(EditorFrameProperties properties, com.microsoft.playwright.Page page) {
        this.frame = getFrameFromThePage(page, properties.getName());
        this.page = new Page(properties.getWorkspace(), frame);
        this.addButton = () -> new Button(frame.locator(properties.getAddButton()));
        this.mainPage = page;
    }

    private Frame getFrameFromThePage(com.microsoft.playwright.Page page, String frameName) {
        int now = LocalDateTime.now().getSecond();
        while(LocalDateTime.now().getSecond() - now < 30 && Objects.isNull(page.frame(frameName))) {}
        return page.frame(frameName);
    }

    public void openPopUpMenu() {
        addButton.get().click();
    }

    public void addComponent(List<SidebarItemDto> elements, Function<EditorSidebarElement, Div> findSidebarElementByType) {
        for (SidebarItemDto element : elements) {
            Div elementToCreate = findSidebarElementByType.apply(element.getType());
            Section sectionToAddElementTo = page.getSection(element.getSectionName());
            Component parentElement = Try.of(() -> sectionToAddElementTo.getComponentByName(element.getParentName())).getOrElse(() -> null);
            sectionToAddElementTo.addComponent(elementToCreate, parentElement, element);
        }
    }

    public void configureComponents(List<SidebarItemDto> elements) {
        for (SidebarItemDto element : elements) {
            Section sectionToAddElementTo = page.getSection(element.getSectionName());
            Component foundComponent = sectionToAddElementTo.getComponentByName(element.getElementName());
            foundComponent.customize().withProperties(element.getComponentProperties());
            mainPage.mouse().click(100, 100);
        }
    }

    public Component get(String sectionName, String componentName) {
        return page.getSection(sectionName).getComponentByName(componentName);
    }

    public void addSection(String sectionName) {
        page.addSection(sectionName);
    }

    public void waitForFrameLoadState() {
        frame.waitForLoadState(LoadState.LOAD);
    }

}