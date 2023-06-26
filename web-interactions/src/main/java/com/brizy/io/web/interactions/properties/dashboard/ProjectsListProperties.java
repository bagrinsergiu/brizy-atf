package com.brizy.io.web.interactions.properties.dashboard;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ProjectsListProperties {

    String self;
    String items;
    @NestedConfigurationProperty
    ProjectProperties project;
}
