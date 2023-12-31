package com.brizy.io.web.test.steps.actions;

import com.brizy.io.web.interactions.locators.WebLocatorsProperties;
import com.brizy.io.web.interactions.locators.dashboard.DashboardPageLocators;
import com.brizy.io.web.interactions.page.dashboard.DashboardPage;
import com.brizy.io.web.interactions.page.dashboard.projects.Project;
import com.brizy.io.web.test.service.ActivePageService;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DashboardPageSteps {

    ActivePageService activePageService;
    DashboardPageLocators dashboardPageLocators;
    Storage storage;

    @Autowired
    public DashboardPageSteps(ActivePageService activePageService, WebLocatorsProperties webLocatorsProperties, Storage storage) {
        this.activePageService = activePageService;
        this.dashboardPageLocators = webLocatorsProperties.getDashboard();
        this.storage = storage;
    }

    @When("^select '(.*)' from projects list$")
    public void selectProjectFromProjectsList(String projectName) {
        Page page = activePageService.getPage();
        DashboardPage dashboardPage = new DashboardPage(dashboardPageLocators, page);
        Project projectByTitle = dashboardPage.getProjectByTitle(projectName);
        projectByTitle.edit();
    }

}
