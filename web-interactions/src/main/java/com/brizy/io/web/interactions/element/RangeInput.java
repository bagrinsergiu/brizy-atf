package com.brizy.io.web.interactions.element;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class RangeInput {

    Locator locator;

    public void fill(Integer integer) {
        ElementHandle elementHandle = locator.elementHandle();
        elementHandle.fill(integer.toString());
    }

    public Integer getValue() {
        return Integer.valueOf(locator.inputValue());
    }

}
