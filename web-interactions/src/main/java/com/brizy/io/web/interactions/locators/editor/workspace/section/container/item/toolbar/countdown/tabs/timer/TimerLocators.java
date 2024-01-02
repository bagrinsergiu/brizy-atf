package com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.countdown.tabs.timer;

import com.brizy.io.web.interactions.locators.AbstractLocator;
import com.brizy.io.web.interactions.locators.editor.workspace.section.container.item.toolbar.common.DropdownWithPopulationLocators;
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
public class TimerLocators extends AbstractLocator {

    String configurations;
    String style;
    @NestedConfigurationProperty
    DropdownWithPopulationLocators date;
    @NestedConfigurationProperty
    DropdownWithPopulationLocators hour;
    @NestedConfigurationProperty
    DropdownWithPopulationLocators minutes;
    String timeZone;

}
