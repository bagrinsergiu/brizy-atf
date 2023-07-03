package com.brizy.io.web.interactions.components.common;

import com.brizy.io.web.interactions.dto.editor.container.ElementPositionDto;
import com.brizy.io.web.interactions.dto.editor.container.ElementSizeDto;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class GenericComponent {

    @Getter
    Locator componentLocator;
    BoundingBox boundingBox;

    public GenericComponent(Locator componentLocator) {
        this.componentLocator = componentLocator;
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

    public Map getProperties() {
        return ((Map) componentLocator.evaluate("element => window.getComputedStyle(element, '::before')", componentLocator.elementHandle()));
    }

}
