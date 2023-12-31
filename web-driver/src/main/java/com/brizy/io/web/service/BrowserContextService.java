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
        Cookie e = new Cookie("CLOUDREMEMBERME", "QXBwQnVuZGxlXEVudGl0eVxVc2VyOllYVjBiMjFoZEdsdmJsOTFjMlZ5OjE3MDgxMDAwMjI6MjZiNjE2ODIxYzIxNDYzMjk5ZmY3ZTU0NzQwNmZlNTI5OTJkYTQ1NDI4MWU5ZGE0OGZiN2M3OWJkMDNmNzY5NA%3D%3D");
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
