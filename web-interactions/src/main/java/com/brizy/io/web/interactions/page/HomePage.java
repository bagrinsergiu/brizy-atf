package com.brizy.io.web.interactions.page;

import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.HomePageLocators;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HomePage extends AbstractPage {

    Supplier<Button> getStarted;

    public HomePage(HomePageLocators homePageLocators, Page page) {
        super(page);
        getStarted = () -> new Button(page.locator(homePageLocators.getGetStarted()));
    }

    public void openDashboard() {
        getStarted.get().click();
    }

}
