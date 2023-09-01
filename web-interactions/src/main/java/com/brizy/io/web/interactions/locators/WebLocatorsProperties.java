package com.brizy.io.web.interactions.locators;

import com.brizy.io.web.interactions.locators.dashboard.DashboardPageProperties;
import com.brizy.io.web.interactions.locators.editor.EditorPageProperties;
import com.brizy.io.web.interactions.locators.publish.PublishPageProperties;
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
    HomePageProperties home;
    @NestedConfigurationProperty
    DashboardPageProperties dashboard;
    @NestedConfigurationProperty
    EditorPageProperties editor;
    @NestedConfigurationProperty
    PublishPageProperties publish;

}
