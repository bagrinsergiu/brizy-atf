package com.brizy.io.web.interactions.page.dashboard;

import com.brizy.io.web.interactions.page.AbstractPage;
import com.brizy.io.web.interactions.page.dashboard.projects.Project;
import com.brizy.io.web.interactions.page.dashboard.projects.ProjectsDashboard;
import com.brizy.io.web.interactions.properties.dashboard.DashboardPageProperties;
import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DashboardPage extends AbstractPage {

    ProjectsDashboard projectsDashboard;

    public DashboardPage(DashboardPageProperties dashboardPageProperties, Page page) {
        super(page);
        this.projectsDashboard = new ProjectsDashboard(dashboardPageProperties.getProjects(), page);
    }

    public Project getProjectByTitle(String title) {
        return projectsDashboard.getProject(title);
    }

}
