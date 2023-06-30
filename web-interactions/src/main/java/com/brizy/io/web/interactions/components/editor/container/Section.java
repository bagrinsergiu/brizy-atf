package com.brizy.io.web.interactions.components.editor.container;

import com.brizy.io.web.interactions.components.editor.container.components.Component;
import com.brizy.io.web.interactions.components.editor.container.components.EmptyContainer;
import com.brizy.io.web.interactions.components.factory.ComponentsFactory;
import com.brizy.io.web.interactions.dto.editor.sidebar.SidebarItemDto;
import com.brizy.io.web.interactions.element.Div;
import com.brizy.io.web.interactions.properties.editor.workspace.section.SectionProperties;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.ItemProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import io.vavr.API;
import lombok.Getter;
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
public class Section {

    @Getter
    String uuid;
    Map<String, Component> sectionComponents;
    Supplier<Locator> emptyContainer;
    String addedItemsLocator;
    ItemProperties itemProperties;
    Locator sectionLocator;
    Frame frame;

    public Section(SectionProperties sectionProperties, Frame frame, Locator locator) {
        this.frame = frame;
        this.sectionLocator = locator;
        this.uuid = locator.getAttribute("data-uid");
        this.sectionComponents = new HashMap<>();
        this.emptyContainer = () -> sectionLocator.locator(sectionProperties.getContainer().getEmpty());
        this.addedItemsLocator = sectionProperties.getContainer().getItem().getSelf();
        this.itemProperties = sectionProperties.getContainer().getItem();
    }

    public Component addComponent(Div sidebarElement, Component parent, SidebarItemDto item) {
        if (Objects.isNull(parent)) {
            parent = new EmptyContainer(emptyContainer.get());
        }
        parent.moveElementToPosition(sidebarElement, item.getElementPosition());
        return sectionComponents.put(item.getElementName(), getLastAddedComponent());
    }

    public Component getLastAddedComponent() {
        List<Component> components = getComponents();
        return components.get(components.size() - 1);
    }

    public <T extends Component> List<T> getComponents() {
        return sectionLocator.locator(addedItemsLocator).all().stream()
                .map(sectionLocator -> sectionLocator.locator("//div").first())
                .map(component -> ComponentsFactory.getComponentByType(component, frame, itemProperties))
                .map(component -> (T) component)
                .collect(Collectors.toList());
    }

    public Component getComponentByName(String elementName) {
        return sectionComponents.get(elementName);
    }

    private <T extends Component> T getElement(Component component, Class<T> clazz) {
        return API.Match(clazz)
                .option(Case($(cls -> cls.isInstance(component)), clazz.cast(component)))
                .getOrNull();
    }

}