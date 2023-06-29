package com.brizy.io.web.interactions.components.editor.container.components;

import com.brizy.io.web.interactions.components.editor.container.components.toolbar.ComponentToolbar;
import com.brizy.io.web.interactions.dto.editor.container.ElementPositionDto;
import com.brizy.io.web.interactions.dto.editor.container.ElementSizeDto;
import com.brizy.io.web.interactions.element.Div;
import com.brizy.io.web.interactions.enums.ComponentPositions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Component {

    @Getter
    Locator locator;
    BoundingBox boundingBox;

    public Component(Locator componentLocator) {
        this.locator = componentLocator;
        this.boundingBox = componentLocator.boundingBox();
    }

    public ElementPositionDto getPosition() {
        return ElementPositionDto.builder()
                .x(boundingBox.x)
                .y(boundingBox.y)
                .build();
    }

    public ElementSizeDto getSize() {
        return ElementSizeDto.builder()
                .height(boundingBox.height)
                .width(boundingBox.width)
                .build();
    }

    protected abstract ComponentToolbar getToolbar();

    public void moveElementToPosition(Div element, ComponentPositions position) {
        ElementPositionDto positionToMoveElementTo = position.getPosition(getSize(), getPosition());
        element.moveWithMouse(positionToMoveElementTo);
    }

    public ComponentToolbar customize() {
        locator.click();
        return getToolbar();
    }

}
