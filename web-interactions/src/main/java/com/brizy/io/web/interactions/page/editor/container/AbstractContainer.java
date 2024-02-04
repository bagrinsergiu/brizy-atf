package com.brizy.io.web.interactions.page.editor.container;

import com.brizy.io.web.interactions.dto.editor.sidebar.SidebarItemDto;
import com.brizy.io.web.interactions.element.Div;
import com.brizy.io.web.interactions.locators.editor.workspace.section.SectionLocators;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.editor.container.components.Component;
import com.brizy.io.web.interactions.page.editor.container.components.EmptyContainer;
import com.brizy.io.web.interactions.page.factory.ComponentsFactory;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import io.vavr.API;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@SuppressWarnings("all")
@NoArgsConstructor(force = true)
public class AbstractContainer {

    String uuidAttribute = "data-brz-uid";
    @Getter
    String uuid;
    Map<String, Component> sectionComponents;
    Supplier<Locator> emptyContainer;
    String addedItemsLocator;
    String parentItemLocator;
    SectionLocators sectionLocators;
    ItemLocators itemLocators;
    Locator sectionLocator;
    Frame frame;

    public AbstractContainer(SectionLocators sectionLocators, Frame frame, Locator locator) {
        this.frame = frame;
        this.sectionLocator = locator;
        this.uuid = locator.getAttribute(uuidAttribute);
        this.sectionComponents = new HashMap<>();
        this.emptyContainer = () -> sectionLocator.locator(sectionLocators.getContainer().getEmpty());
        this.addedItemsLocator = sectionLocators.getContainer().getItem().getSelf();
        this.parentItemLocator = sectionLocators.getContainer().getParentContainer();
        this.itemLocators = sectionLocators.getContainer().getItem();
        this.sectionLocators = sectionLocators;
    }

    public Component addComponent(Div sidebarElement, Component parent, SidebarItemDto item) {
        if (Objects.isNull(parent)) {
            parent = new EmptyContainer(emptyContainer.get());
        }
        parent.scrollToElement();
        parent.moveElementToPosition(sidebarElement, item.getElementPosition());
        if (!item.hasParent() && !item.getIsParent()) {
            return sectionComponents.put(item.getElementName(), getLastAddedComponent());
        }
        return sectionComponents.put(item.getElementName(), getLastParentComponent());
    }

    public Component getLastAddedComponent() {
        List<Component> components = getComponents();
        return components.get(components.size() - 1);
    }

    public Component getLastParentComponent() {
        List<Component> components = getParentComponents();
        return components.get(components.size() - 1);
    }

    public <T extends Component> List<T> getParentComponents() {
        return sectionLocator.locator(parentItemLocator).all().stream()
                .map(component -> ComponentsFactory.getParentComponentByType(component, frame, sectionLocators))
                .map(component -> (T) component)
                .collect(Collectors.toList());
    }


    public <T extends Component> List<T> getComponents() {
        return sectionLocator.locator(addedItemsLocator).all().stream()
                .map(sectionLocator -> sectionLocator.locator("//div").first())
                .map(component -> ComponentsFactory.getComponentByType(component, frame, itemLocators))
                .map(component -> (T) component)
                .collect(Collectors.toList());
    }

    public Component getComponentByName(String elementName) {
        return sectionComponents.get(elementName);
    }

    public AbstractContainer getParentComponentByName() {
        return null;
    }

    private <T extends Component> T getElement(Component component, Class<T> clazz) {
        return API.Match(clazz)
                .option(Case($(cls -> cls.isInstance(component)), clazz.cast(component)))
                .getOrNull();
    }

}