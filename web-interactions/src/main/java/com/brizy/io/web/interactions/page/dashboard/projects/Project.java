package com.brizy.io.web.interactions.page.dashboard.projects;

import com.brizy.io.web.interactions.dto.dashboard.ProjectDto;
import com.brizy.io.web.interactions.element.Button;
import com.brizy.io.web.interactions.element.TextInput;
import com.brizy.io.web.interactions.locators.dashboard.ProjectProperties;
import com.microsoft.playwright.Locator;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Project {

    Supplier<TextInput> title;
    Supplier<Button> publish;
    Supplier<Button> openProject;
    Supplier<Button> editProject;
    Supplier<ProjectMenu> projectMenu;

    public Project(ProjectProperties properties, Locator locator) {
        this.title = () -> new TextInput(locator.locator(properties.getTitle()));
        this.publish = () -> new Button(locator.locator(properties.getPublishProject()));
        this.openProject = () -> new Button(locator.locator(properties.getOpenProject()));
        this.editProject = () -> new Button(locator.locator(properties.getEdit()));
        this.projectMenu = () -> new ProjectMenu(properties.getMenu(), locator);
    }

    public ProjectDto get() {
        return ProjectDto.builder()
                .title(title.get().getRawValue())
                .build();
    }

    public void edit() {
        editProject.get().click();
    }

    public void delete() {
        projectMenu.get().open().delete();
    }

}
