package com.brizy.io.web.service;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.options.Cookie;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.util.Collections;
import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@FieldDefaults(makeFinal = true, level = PRIVATE)
class BrowserContextService {

    NewContextOptions contextProperties;
    @Getter(value = PROTECTED)
    @NonFinal
    BrowserContext context;

    protected BrowserContextService(NewContextOptions contextProperties) {
        this.contextProperties = contextProperties;
    }

    protected BrowserContext newContext(Browser browser) {
        BrowserContext browserContext = browser.newContext(contextProperties);
        Cookie e = new Cookie("CLOUDREMEMBERME", "QXBwQnVuZGxlXEVudGl0eVxVc2VyOmRHVnpkRjkxYzJWeU5UTTE6MTY5Mjk4MjgwMzo4ZWExMjM2MGFkMDdmOTM3OTU2YmVmNTBhMThkMzM5NmE5NDAwODc1MDY5YzlkZDIyZTAwZDU5NWM3NWIyNTg3");
        e.setDomain("www.brizy.cloud");
        e.setPath("/");
        browserContext.addCookies(Collections.singletonList(e));
        return browserContext;
    }

    protected void close() {
        if (Objects.nonNull(context)) {
            context.close();
        }
    }

}
