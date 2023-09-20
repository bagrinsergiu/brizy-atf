package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.interactions.dto.editor.container.ElementPositionDto;
import com.brizy.io.web.interactions.dto.editor.container.properties.CssProperties;
import com.brizy.io.web.interactions.element.Div;
import com.brizy.io.web.interactions.enums.ComponentPositions;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.common.GenericComponent;
import com.brizy.io.web.interactions.page.editor.container.components.context_menu.ContextMenu;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import static com.microsoft.playwright.options.MouseButton.RIGHT;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class Component<T extends Property> extends GenericComponent {

    ItemLocators componentProperties;
    Frame frame;

    public Component(Frame frame, Locator componentLocator, ItemLocators itemLocators) {
        super(componentLocator);
        this.componentProperties = itemLocators;
        this.frame = frame;
    }

    /**
     * To be used only with empty container - when there is no need for some locators
     *
     * @param componentLocator - location of the component
     */
    public Component(Locator componentLocator) {
        super(componentLocator);
        this.componentProperties = new ItemLocators();
        this.frame = componentLocator.page().mainFrame();
    }

    protected abstract T getEditorProperties();

    protected abstract ComponentToolbar<T> getToolbar();

    public void moveElementToPosition(Div element, ComponentPositions position) {
        ElementPositionDto positionToMoveElementTo = position.getPosition(getSize(), getPosition());
        element.moveWithMouse(positionToMoveElementTo);
    }

    private ComponentToolbar<T> openAndGetToolbar() {
        getComponentLocator().click();
        return getToolbar();
    }

    //    TODO check if it will work with configure method an remove
    public ComponentToolbar<T> onToolbar() {
        return openAndGetToolbar();
    }

    public ContextMenu onContextMenu() {
        getComponentLocator().click(new Locator.ClickOptions().setButton(RIGHT));
        return new ContextMenu(frame, componentProperties.getRightClickContext());
    }

    public GetProperties get() {
        openAndGetToolbar();
        return new GetProperties();
    }

    public void configure(T properties) {
        openAndGetToolbar().setProperties(properties);
    }

    public class GetProperties {

        public T editorItemProperties() {
            return getEditorProperties();
        }

        public CssProperties cssItemProperties() {
            return getProperties();
        }

    }

}
