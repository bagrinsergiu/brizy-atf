package com.brizy.io.web.test.service;

import com.microsoft.playwright.Page;
import io.cucumber.spring.ScenarioScope;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Data
@Service
@ScenarioScope
public class ActivePageService {

    Page page;

    public void setPage(Page page) {
        if (Objects.nonNull(this.page)) {
            this.page.close();
        }
        this.page = page;
    }

    public void closePage() {
        page.close();
    }

}
