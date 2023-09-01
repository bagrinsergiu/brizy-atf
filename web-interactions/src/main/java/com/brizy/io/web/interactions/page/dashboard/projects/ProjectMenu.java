package com.brizy.io.web.interactions.page.dashboard.projects;


import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.locators.dashboard.ProjectMenuProperties;
import com.microsoft.playwright.Locator;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ProjectMenu {

    Supplier<Button> showMore;
    Supplier<Button> delete;

    public ProjectMenu(ProjectMenuProperties menu, Locator locator) {
        this.showMore = () -> new Button(locator.locator(menu.getSelf()));
        this.delete = () -> new Button(locator.locator(menu.getDelete()));
    }

    public MenuOperations open() {
        showMore.get().click();
        return new MenuOperations();
    }

    protected class MenuOperations {

        public void delete() {
            delete.get().click();
        }

    }


}
