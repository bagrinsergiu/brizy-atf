package com.brizy.io.web.test.enums;

import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.function.Function;

@Getter
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public enum AttributeTypes {

    VALUE(locator -> locator.getAttribute("value")),
    TEXT(Locator::textContent);

    Function<Locator, String> extractionFunction;

}
