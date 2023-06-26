package com.brizy.io.web.interactions.element.frame.container;

import com.brizy.io.web.interactions.exception.PageElementNotFound;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Data
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Page {

    @Getter
    Map<String, PageElement> elements;

    public Page() {
        this.elements = new HashMap<>();
    }

    public PageElement getElement(String elementName) {
        return Optional.of(elements.get(elementName))
                .orElseThrow(() -> new PageElementNotFound(String.format("Element with name %s was not found on page", elementName)));
    }

    public PageElement addElement(String name, PageElement pageElement) {
        elements.put(name, pageElement);
        return pageElement;
    }

}
