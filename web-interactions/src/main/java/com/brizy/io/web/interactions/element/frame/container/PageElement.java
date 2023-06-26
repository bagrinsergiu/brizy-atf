package com.brizy.io.web.interactions.element.frame.container;

import com.brizy.io.web.interactions.dto.workspace.ElementPositionDto;
import com.brizy.io.web.interactions.dto.workspace.ElementSizeDto;
import com.brizy.io.web.interactions.element.Div;
import com.brizy.io.web.interactions.enums.ElementPositions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;

public class PageElement {

    Locator locator;
    BoundingBox boundingBox;

    public PageElement(Locator locator) {
        this.locator = locator;
        this.boundingBox = locator.boundingBox();
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

    public void moveElementToPosition(Div element, ElementPositions position) {
        ElementPositionDto positionToMoveElementTo = position.getPosition(getSize(), getPosition());
        element.moveWithMouse(positionToMoveElementTo);
    }

}
