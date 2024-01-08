package com.brizy.io.web.interactions.page.editor.container.components;

import com.brizy.io.web.common.dto.element.properties.Property;
import com.brizy.io.web.interactions.dto.editor.container.ElementPositionDto;
import com.brizy.io.web.interactions.dto.editor.container.ElementSizeDto;
import com.brizy.io.web.interactions.element.Div;
import com.brizy.io.web.interactions.enums.ComponentPositions;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.ItemLocators;
import com.brizy.io.web.interactions.page.common.GenericComponent;
import com.brizy.io.web.interactions.page.editor.container.components.context_menu.ContextMenu;
import com.brizy.io.web.interactions.page.editor.container.components.toolbar.Toolbar;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

import static com.microsoft.playwright.options.MouseButton.RIGHT;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class Component<T extends Property> extends GenericComponent {

    Supplier<BoundingBox> boundingBox;
    ItemLocators componentProperties;
    Frame frame;
    Locator componentLocator;

    public Component(Frame frame, Locator componentLocator, ItemLocators itemLocators) {
        this.componentProperties = itemLocators;
        this.frame = frame;
        this.boundingBox = componentLocator::boundingBox;
        this.componentLocator = componentLocator;
    }

    /**
     * To be used only with empty container - when there is no need for some locators
     *
     * @param componentLocator - location of the component
     */
    public Component(Locator componentLocator) {
        this.componentProperties = new ItemLocators();
        this.frame = componentLocator.page().mainFrame();
        this.componentLocator = componentLocator;
        this.boundingBox = componentLocator::boundingBox;
    }

    protected abstract T getEditorProperties();

    protected abstract Toolbar<T> getToolbar();

    protected ElementPositionDto getPosition() {
        return ElementPositionDto.builder()
                .x(boundingBox.get().x)
                .y(boundingBox.get().y)
                .build();
    }

    protected ElementSizeDto getSize() {
        return ElementSizeDto.builder()
                .height(boundingBox.get().height)
                .width(boundingBox.get().width)
                .build();
    }

    protected BoundingBox getBoundingBox() {
        return boundingBox.get();
    }

    public void moveElementToPosition(Div element, ComponentPositions position) {
        ElementPositionDto positionToMoveElementTo = position.getPosition(getSize(), getPosition());
        element.moveWithMouse(positionToMoveElementTo);
    }

    public void scrollToElement() {
        componentLocator.scrollIntoViewIfNeeded();
    }

    protected void openToolbar() {
        componentLocator.click();
    }

    private Toolbar<T> openAndGetToolbar() {
        componentLocator.hover();
        openToolbar();
        return getToolbar();
    }

    //    TODO check if it will work with configure method an remove
    public Toolbar<T> onToolbar() {
        return openAndGetToolbar();
    }

    public ContextMenu onContextMenu() {
        componentLocator.click(new Locator.ClickOptions().setButton(RIGHT));
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

    }

}
