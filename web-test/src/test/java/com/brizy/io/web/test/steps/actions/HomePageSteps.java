package com.brizy.io.web.test.steps.actions;

import com.brizy.io.web.interactions.page.HomePage;
import com.brizy.io.web.interactions.properties.HomePageProperties;
import com.brizy.io.web.interactions.properties.WebLocatorsProperties;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.service.ActivePageService;
import com.brizy.io.web.test.storage.Storage;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HomePageSteps {

    ActivePageService activePageService;
    HomePageProperties locatorsProperties;
    Storage storage;

    @Autowired
    public HomePageSteps(ActivePageService activePageService, WebLocatorsProperties webLocatorsProperties, Storage storage) {
        this.activePageService = activePageService;
        this.storage = storage;
        this.locatorsProperties = webLocatorsProperties.getHome();
    }

    @When("navigate to home page")
    public void navigateToHomePage() {
        HomePage homePage = new HomePage(locatorsProperties, activePageService.getPage());
        storage.addValue(StorageKey.HOME_PAGE, homePage);
    }

    @When("open dashboard page")
    public void navigateToDashboardPage() {
        HomePage homePage = storage.getValue(StorageKey.HOME_PAGE, HomePage.class);
        Page dashboardPage = activePageService.getPage().waitForPopup(homePage::openDashboard);
        dashboardPage.waitForLoadState();
        activePageService.setPage(dashboardPage);
    }

}