package com.brizy.io.web.enums;

import com.microsoft.playwright.Playwright;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.function.Function;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public enum BrowserType {

    CHROMIUM(Playwright::chromium),
    WEBKIT(Playwright::webkit),
    FIREFOX(Playwright::firefox);

    Function<Playwright, com.microsoft.playwright.BrowserType> type;

    public com.microsoft.playwright.BrowserType getBrowserType(Playwright playwright) {
        return type.apply(playwright);
    }

}
