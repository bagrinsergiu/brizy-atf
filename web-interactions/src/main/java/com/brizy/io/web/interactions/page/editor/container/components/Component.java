package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.interactions.page.common.GenericComponent;
import com.brizy.io.web.interactions.page.editor.container.components.context_menu.ComponentContextMenu;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.dto.editor.container.ElementPositionDto;
import com.brizy.io.web.interactions.dto.editor.container.properties.CssProperties;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.element.Div;
import com.brizy.io.web.interactions.enums.ComponentPositions;
import com.brizy.io.web.interactions.properties.editor.workspace.section.container.item.ItemProperties;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import static com.microsoft.playwright.options.MouseButton.RIGHT;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class Component extends GenericComponent {

    ItemProperties componentProperties;
    Frame frame;

    public Component(Frame frame, Locator componentLocator, ItemProperties itemProperties) {
        super(componentLocator);
        this.componentProperties = itemProperties;
        this.frame = frame;
    }

    /**
     * To be used only with empty container - when there is no need for some locators
     *
     * @param componentLocator - location of the component
     */
    public Component(Locator componentLocator) {
        super(componentLocator);
        this.componentProperties = new ItemProperties();
        this.frame = componentLocator.page().mainFrame();
    }

    protected abstract EditorComponentProperty getEditorProperties();

    protected abstract ComponentToolbar getToolbar();

    public void moveElementToPosition(Div element, ComponentPositions position) {
        ElementPositionDto positionToMoveElementTo = position.getPosition(getSize(), getPosition());
        element.moveWithMouse(positionToMoveElementTo);
    }

    private ComponentToolbar openAndGetToolbar() {
        getComponentLocator().click();
        return getToolbar();
    }

    public ComponentToolbar customize() {
        return openAndGetToolbar();
    }

    public ComponentContextMenu onContextMenu() {
        getComponentLocator().click(new Locator.ClickOptions().setButton(RIGHT));
        return new ComponentContextMenu(frame, componentProperties.getRightClickContext());
    }

    public GetProperties get() {
        openAndGetToolbar();
        return new GetProperties();
    }

    public class GetProperties {

        public EditorComponentProperty editorItemProperties() {
            return getEditorProperties();
        }

        public CssProperties cssItemProperties() {
            return getProperties();
        }

    }

}