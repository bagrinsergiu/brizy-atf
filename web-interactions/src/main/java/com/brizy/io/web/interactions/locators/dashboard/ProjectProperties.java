package com.brizy.io.web.interactions.locators.dashboard;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ProjectProperties {

    String title;
    String openProject;
    String publishProject;
    String edit;
    @NestedConfigurationProperty
    ProjectMenuProperties menu;

}
