package com.brizy.io.web.service;


import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PUBLIC;
import static org.apache.commons.lang3.StringUtils.EMPTY;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
class PageService {

    @Getter(value = PUBLIC, onMethod = @__({@Bean}))
    Page page;

    @Autowired
    public PageService(BrowserContext context) {
        this.page = context.newPage();
        this.page.navigate(EMPTY);
    }

}