package com.brizy.io.web.interactions.locators;

import com.brizy.io.web.interactions.locators.dashboard.DashboardPageLocators;
import com.brizy.io.web.interactions.locators.editor.EditorPageLocators;
import com.brizy.io.web.interactions.locators.publish.PublishPageLocators;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
@ConfigurationProperties(prefix = "pages")
public class WebLocatorsProperties {

    @NestedConfigurationProperty
    HomePageLocators home;
    @NestedConfigurationProperty
    DashboardPageLocators dashboard;
    @NestedConfigurationProperty
    EditorPageLocators editor;
    @NestedConfigurationProperty
    PublishPageLocators publish;

}
