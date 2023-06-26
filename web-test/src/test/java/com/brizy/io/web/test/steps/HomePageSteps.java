package com.brizy.io.web.test.steps;

import com.brizy.io.web.interactions.page.HomePage;
import com.brizy.io.web.interactions.properties.HomePageProperties;
import com.brizy.io.web.interactions.properties.WebLocatorsProperties;
import com.brizy.io.web.test.enums.StorageKey;
import com.brizy.io.web.test.storage.Storage;
import com.brizy.io.web.test.tools.PageSwitcher;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.When;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import static org.apache.commons.lang3.StringUtils.EMPTY;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HomePageSteps {

    HomePageProperties locatorsProperties;
    PageSwitcher pageSwitcher;
    Storage storage;

    @Autowired
    public HomePageSteps(WebLocatorsProperties webLocatorsProperties, Storage storage) {
        this.pageSwitcher = new PageSwitcher();
        this.storage = storage;
        this.locatorsProperties = webLocatorsProperties.getHome();
    }

    @When("navigate to home page")
    public void navigateToHomePage() {
        Page page = storage.getValue(StorageKey.PAGE, Page.class);
        page.navigate(EMPTY);
        HomePage homePage = new HomePage(locatorsProperties, page);
        storage.addValue(StorageKey.HOME_PAGE, homePage);
    }

    @When("open dashboard page")
    public void navigateToDashboardPage() {
        HomePage homePage = storage.getValue(StorageKey.HOME_PAGE, HomePage.class);
        Page page = storage.getValue(StorageKey.PAGE, Page.class);
        homePage.openDashboard();
        Page dashboardPage = pageSwitcher.switchFromCurrentPageToSpecificTab(page, 1);
        storage.addValue(StorageKey.DASHBOARD_PAGE, dashboardPage);
    }


}
