package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.Locator;
import io.vavr.API;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public abstract class AbstractElement implements Element {

    Locator locator;

    public Boolean isVisible() {
        return locator.isVisible();
    }

    @Override
    public <T> T getText(Class<T> clazz) {
        return getTextContent(clazz, locator.textContent());
    }

    <T> T getTextContent(Class<T> clazz, String textContent) {
        return (T) API.Match(clazz).of(
                API.Case(API.$(type -> type.isAssignableFrom(String.class)), () -> textContent),
                API.Case(API.$(type -> type.isAssignableFrom(Integer.class)), () -> Integer.parseInt(textContent)),
                API.Case(API.$(type -> type.isAssignableFrom(Double.class)), () -> Double.parseDouble(textContent)),
                API.Case(API.$(), () -> null)
        );
    }

    @Override
    public String getText() {
        return locator.textContent();
    }
}
