package com.brizy.io.web.service;

import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Playwright.CreateOptions;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
@FieldDefaults(level = PRIVATE)
class PlaywrightService {

    @Getter(value = PROTECTED)
    Playwright playwright;
    CreateOptions createOptions;

    protected PlaywrightService(CreateOptions createOptions) {
        this.createOptions = createOptions;
    }

    protected Playwright create() {
        return Playwright.create(createOptions);
    }

    protected void close() {
        if (Objects.nonNull(playwright)) {
            playwright.close();
        }
    }

}
