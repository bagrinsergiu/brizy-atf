package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.alert;

import com.brizy.io.web.interactions.locators.AbstractProperty;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.alert.tabs.AlertTabsLocators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = false)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class AlertLocators extends AbstractProperty {

    @NestedConfigurationProperty
    AlertTabsLocators tabs;

}
