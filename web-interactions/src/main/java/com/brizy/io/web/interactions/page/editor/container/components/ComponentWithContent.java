package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.common.dto.element.type.Content;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class ComponentWithContent<T extends Property> extends Component<T> {

    public ComponentWithContent(Frame frame, Locator componentLocator, ItemLocators itemLocators) {
        super(frame, componentLocator, itemLocators);
    }

    /**
     * To be used only with empty container - when there is no need for some locators
     *
     * @param componentLocator - location of the component
     */
    public ComponentWithContent(Locator componentLocator) {
        super(componentLocator);
    }

    public <Type extends Content> void configureContents(List<Type> content) {
    }

}
