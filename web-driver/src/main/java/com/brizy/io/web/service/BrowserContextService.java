package com.brizy.io.web.service;


import com.brizy.io.web.property.WebDriverProperties;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.options.Cookie;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Objects;

import static lombok.AccessLevel.*;

@Configuration
@FieldDefaults(makeFinal = true, level = PRIVATE)
class BrowserContextService {

    @Getter(value = PUBLIC, onMethod = @__({@Bean}))
    BrowserContext context;

    protected BrowserContextService(Browser browser, ModelMapper modelMapper, WebDriverProperties props) {
        NewContextOptions contextOptions = modelMapper.map(props.getContext(), NewContextOptions.class);
        BrowserContext browserContext = browser.newContext(contextOptions);
        Cookie e = new Cookie("CLOUDREMEMBERME", "QXBwQnVuZGxlXEVudGl0eVxVc2VyOmRHVnpkRjkxYzJWeU5UTTE6MTY5NzExNzQ3OTozMmRhNGQzMDM2MWY0YTc0YWE4Mjk4MDM1YmJkMmIyODkxNDE5MjQ1M2ZlMjg4ZTdlZDk0MTAxNmU2ZjRhZDg1%3D%3D");
        e.setDomain("www.brizy.cloud");
        e.setPath("/");
        browserContext.addCookies(Collections.singletonList(e));
        this.context = browserContext;
    }

    protected void cleanUp() {
        if (Objects.nonNull(context)) {
            context.close();
        }
    }

}
