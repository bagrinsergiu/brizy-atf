package com.brizy.io.web.interactions.page.editor.container;

import com.brizy.io.web.interactions.dto.editor.sidebar.SidebarItemDto;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.Div;
import com.brizy.io.web.interactions.enums.EditorSidebarElement;
import com.brizy.io.web.interactions.locators.editor.EditorFrameProperties;
import com.brizy.io.web.interactions.page.editor.container.components.Component;
import com.brizy.io.web.interactions.page.editor.container.components.ComponentWithContent;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.options.LoadState;
import io.vavr.control.Try;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.brizy.io.web.interactions.constants.TimingConstants.MAX_WAITING_TIME_FOR_FRAME_TO_LOAD;
import static java.time.Duration.ZERO;
import static lombok.AccessLevel.PRIVATE;
import static org.awaitility.Awaitility.await;

@SuppressWarnings({"unchecked", "ConstantConditions"})
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
        return await().given().alias("Waiting for frame to load")
                .with().atLeast(ZERO).and().atMost(MAX_WAITING_TIME_FOR_FRAME_TO_LOAD)
                .with().pollInSameThread()
                .with().conditionEvaluationListener(condition -> page.reload())
                .with().conditionEvaluationListener(condition -> page.waitForLoadState())
                .then().until(() -> page.frame(frameName), Objects::nonNull);
    }

    public void openPopUpMenu() {
        addButton.get().click();
    }

    public void addComponent(List<SidebarItemDto> elements, Function<EditorSidebarElement, Div> findSidebarElementByType) {
        for (SidebarItemDto element : elements) {
            Div elementToCreate = findSidebarElementByType.apply(element.getType());
            Section sectionToAddElementTo = page.getSection(element.getSectionName());
            var parentElement = Try.of(() -> sectionToAddElementTo.getComponentByName(element.getParentName())).getOrElse(() -> null);
            sectionToAddElementTo.addComponent(elementToCreate, parentElement, element);
            mainPage.waitForLoadState(LoadState.DOMCONTENTLOADED);
        }
    }

    public void configureComponents(List<SidebarItemDto> elements) {
        for (SidebarItemDto element : elements) {
            Section sectionToAddElementTo = page.getSection(element.getSectionName());
            var foundComponent = sectionToAddElementTo.getComponentByName(element.getElementName());
            if (Objects.nonNull(element.getComponentProperties())) {
                foundComponent.configure(element.getComponentProperties());
            }
            if (Objects.nonNull(element.getComponentContent()) && !element.getComponentContent().isEmpty()) {
                ((ComponentWithContent) foundComponent).configureContents(element.getComponentContent());
            }
            mainPage.mouse().click(100, 100);
        }
    }

    public Component getComponent(String sectionName, String componentName) {
        return page.getSection(sectionName).getComponentByName(componentName);
    }

    public List<Component> getComponents(String sectionName) {
        return page.getSection(sectionName).getComponents();
    }

    public void addSection(String sectionName) {
        page.addSection(sectionName);
    }

    public Section getSection(String sectionName) {
        return page.getSection(sectionName);
    }

    public void waitForFrameLoadState() {
        frame.waitForLoadState(LoadState.LOAD);
    }

}