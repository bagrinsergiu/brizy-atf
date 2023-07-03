package com.brizy.io.web.interactions.components.editor.container.components;

import com.brizy.io.web.interactions.components.common.GenericComponent;
import com.brizy.io.web.interactions.components.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.dto.editor.container.ElementPositionDto;
import com.brizy.io.web.interactions.dto.editor.container.toolbar.EditorComponentProperty;
import com.brizy.io.web.interactions.element.Div;
import com.brizy.io.web.interactions.enums.ComponentPositions;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class Component extends GenericComponent {

    public Component(Locator componentLocator) {
        super(componentLocator);
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

    public GetProperties get() {
        openAndGetToolbar();
        return new GetProperties();
    }

    public class GetProperties {

        public EditorComponentProperty editorItemProperties() {
            return getEditorProperties();
        }

        public Map cssItemProperties() {
            return getProperties();
        }

    }

}
